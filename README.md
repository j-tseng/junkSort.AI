# junkSort.AI: an image recognition application for social good

## About the Contributors

[Juliette Lavoie](https://www.linkedin.com/in/juliette-lavoie-ab8086143/), [Julie Tseng](https://www.linkedin.com/in/julietseng), and [Isabella Nikolaidis](https://www.linkedin.com/in/isabella-nikolaidis-227227141/) are a part of the McGill Office of Innovation's [AI for Social Good Summer Lab](https://www.mcgill-innovation.com/ai-summer-lab). This program entails a two week crash course in machine learning and a two week project development phase for members of the lab. 

## About the Project

### Project Selection Process

Given that the program has a fundamental principle of social good, the idea for this project percolated from an interest in promoting and facilitating sustainable practices. A quick search revealed that a few other implementations of image recognition for garbage sorting existed, but none in the form of an app. Additionally, the app approach was chosen as there existed key tutorials on using TensorFlow for image recognition on Android apps. 

### How was the app developed and how does it work?

- Android application based on the [Android ML Example](https://github.com/MindorksOpenSource/AndroidTensorFlowMachineLearningExample/) from the Mindorks community
- Uses the Google [TensorFlow API](https://tensorflow.org) in Java
- Trains the new objects for recycling/compost/trash classification as a final layer on top of pre-trained [Inception V3]((https://arxiv.org/abs/1512.00567)
- Images for final layer taken from [ImageNet](http://www.image-net.org/) sets and contributed by [Gary Thung and Mindy Yang](https://github.com/garythung/trashnet) who also made a trash sorting AI application called TrashNet
- Recognized images classified into .txt lists for each category
- Modifications made to the MainActivity, Classifier, and TensorFlowImageClassifier Java files change text displayed on screen from image label to appropriate category
- Categorisation would only be carried out for objects that were recognized with >40% confidence, otherwise the object was thrown into the trash category
- [Android Studio](https://developer.android.com/studio/index.html) used to test and debug the app

### Challenges encountered in the design process

- Time constraint and varying experience with Android development and image recognition limited scope of projects that were achievable
- Efficiency of image classifier
	- Training length and computational power required made it difficult to train on a large set for final layer
	- ImageNet sets sometimes required cleaning (ex. tea bag set contained many pictures with cups, thus trained model would classify cups as compostable)
- Efficiency of categorisation methodology
	- Simplistic and inelegant approach: after item is recognized, searches from .txt list (finite and non-robust state space)
	- Automatically classify objects with highest confidence level <40% as trash
	- Approach makes it hard to scale with more objects

### Phases of the Project

- [x] PART 1: Image recognition
	- [x] API design choice --> TensorFlow, Inception
	- [x] Minimum viable product - retrain neural net
	- [x] Optimizing model to recognize more objects and with higher accuracy
- [x] PART 2: Categorisation
	- [x] Write code for layer between labeling and output to categorize objects as recyclable, compostable, or trash
	- [x] Develop item lists to use for categorisation
- [x] PART 3: App Design
	- [x] Decide on operating system --> Android
	- [x] Test on device for minimum viable product  --> Works but classification is weak
	- [x] Improve on User Interface design
- [x] PART 4: Wrap up and presentation
	- [x] Create presentation template
	- [x] Fill in content
	- [x] Practice presentation

### Project progression 

Refer to the PROGRESS-TRACK document for summarized progress day by day.

## Thanks to...

- Amir, Angelina, and Angelique from the McGill Innovation Office for organizing and spearheading a great summer lab
- All the mentors who put time aside to teach us about machine learning 
- The power of the Google search engine and StackExchange
	- "If you have a question, chances are someone has already asked it on StackExchange."
- TensorFlow (Google)
	- [Getting Started](https://www.tensorflow.org/get_started/)
	- [Retraining tutorial](https://www.tensorflow.org/tutorials/image_retraining)
- Inception V3 (Google)
	- [Original release paper](https://arxiv.org/abs/1512.00567)
	- [Github](https://github.com/tensorflow/models/tree/master/inception)
- Mindorks Community
	- [Android ML Example](https://github.com/MindorksOpenSource/AndroidTensorFlowMachineLearningExample/)
- TensorFlow for Poets Retraining Tutorials
	- [Introduction](https://codelabs.developers.google.com/codelabs/tensorflow-for-poets/#0)
	- [Android implementation](https://codelabs.developers.google.com/codelabs/tensorflow-for-poets-2/#0)
- Gary Thung and Mindy Yang - TrashBot sorting implementation
	- [Paper](http://cs229.stanford.edu/proj2016/report/ThungYang-ClassificationOfTrashForRecyclabilityStatus-report.pdf)
	- [Github](https://github.com/garythung/trashnet)
- Gautier Mechling - Using TensorFlow on Android, how to train on your own categories
	- [Blog post](http://nilhcem.com/android/custom-tensorflow-classifier)
	- [Github](https://github.com/Nilhcem/tensorflow-classifier-android)
- ImageNet
	- [Category images](http://image-net.org/download)
- Android Studio
	- [Developer Guide](https://developer.android.com/studio/index.html)
