/*
 *    Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.mindorks.tensorflowexample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.flurgle.camerakit.CameraListener;
import com.flurgle.camerakit.CameraView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private static final int INPUT_SIZE = 299; //224;
    private static final int IMAGE_MEAN = 128; //117;
    private static final float IMAGE_STD = 128; //1;
    private static final String INPUT_NAME = "Mul";
    private static final String OUTPUT_NAME = "final_result";
    
	private static ArrayList<String> RECYCLING = new ArrayList<>();
	private static ArrayList<String> COMPOST = new ArrayList<>();

    private static final String MODEL_FILE = "file:///android_asset/rounded_graph.pb";
    private static final String LABEL_FILE =
            "file:///android_asset/retrained_labels24.txt";

    private Classifier classifier;
    private Executor executor = Executors.newSingleThreadExecutor();
    private TextView textViewResult;
    private Button btnDetectObject, btnToggleCamera;
    private ImageView imageViewResult;
    private CameraView cameraView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cameraView = (CameraView) findViewById(R.id.cameraView);
        imageViewResult = (ImageView) findViewById(R.id.imageViewResult);
        textViewResult = (TextView) findViewById(R.id.textViewResult);
        textViewResult.setMovementMethod(new ScrollingMovementMethod());

        btnToggleCamera = (Button) findViewById(R.id.btnToggleCamera);
        btnDetectObject = (Button) findViewById(R.id.btnDetectObject);

        cameraView.setCameraListener(new CameraListener() {
            @Override
            public void onPictureTaken(byte[] picture) {
                super.onPictureTaken(picture);

                String item, bin;
                
                Bitmap bitmap = BitmapFactory.decodeByteArray(picture, 0, picture.length);

                bitmap = Bitmap.createScaledBitmap(bitmap, INPUT_SIZE, INPUT_SIZE, false);

                imageViewResult.setImageBitmap(bitmap);

                final List<Classifier.Recognition> results = classifier.recognizeImage(bitmap);
                
                item = results.toString();
                float conf = results.get(0).getConfidence();

                if (conf > 0.5) {
                    bin = checkCat(item);
                    textViewResult.setText("This belongs in the " + bin + ".\n I am "
                            + String.format("(%.1f%%) ", conf * 100.0f)
                            + "confident.");
                }
                else
                    textViewResult.setText("This belongs in the TRASH.");
            }
        });

        btnToggleCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameraView.toggleFacing();
            }
        });

        btnDetectObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameraView.captureImage();
            }
        });

        initTensorFlowAndLoadModel();
    }

    @Override
    protected void onResume() {
        super.onResume();
        cameraView.start();
    }

    @Override
    protected void onPause() {
        cameraView.stop();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                classifier.close();
            }
        });
    }

    private void initTensorFlowAndLoadModel() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    classifier = TensorFlowImageClassifier.create(
                            getAssets(),
                            MODEL_FILE,
                            LABEL_FILE,
                            INPUT_SIZE,
                            IMAGE_MEAN,
                            IMAGE_STD,
                            INPUT_NAME,
                            OUTPUT_NAME);
                    makeButtonVisible();
                } catch (final Exception e) {
                    throw new RuntimeException("Error initializing TensorFlow!", e);
                }
            }
        });
    }

    private void makeButtonVisible() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                btnDetectObject.setVisibility(View.VISIBLE);
            }
        });
    }
	
	private String checkCat(String item) {
		String cat = "temp";
        genLists();
		for (String thing : RECYCLING) {
			if (item.contains(thing))
				cat = "RECYCLING";
		}
		for (String thing : COMPOST) {
			if (item.contains(thing))
				cat = "COMPOST";
		}
		return cat;
	}
	
	private void genLists() {
		if(RECYCLING.size() == 0) {
		    try {
		        BufferedReader bReader = new BufferedReader(new InputStreamReader(getAssets().open("recList.txt")));
		        String line = bReader.readLine();
		        while (line != null) {
		            RECYCLING.add(line);
		            line = bReader.readLine();
		        }
		        bReader.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
        if(COMPOST.size() == 0) {
            try {
                BufferedReader bReader = new BufferedReader(new InputStreamReader(getAssets().open("compList.txt")));
                String line = bReader.readLine();
                while (line != null) {
                    COMPOST.add(line);
                    line = bReader.readLine();
                }
                bReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
}
