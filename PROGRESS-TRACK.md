# Progress on Project - Day by Day Summaries

## June 20

- Groups officially formed today
- Initial pitch of idea to other lab participants, Angelique Manella, and mentor Ethan
- Received feedback: 
	- Formulate timeline for deliverables starting backwards
	- Determine minimum viable product
	- Start testing at small levels
	- Consider further training on top of trained models
- Juliette and Julie...
	- ... sketched out timeline
	- ... broke down project into smaller tasks
	- ... completed Phase 1: Image Recognition API
	- ... tried out two TensorFlow/Inception based app implementations on Android
	- ... refined timeline and deliverables

## June 21

- Listened to C2RO CEO presentation on product dev
- Canvased business model 
- Updated repo README
- Created summary document to synthesize and track progress
- Tested 2 implementations on phones
- Deliverables of Phase 2:
	- COMPLETE
		- Wrote Java code for text layer in Android app to categorise items
		- Successful trial run on mobile
	- IN PROGRESS
		- Improving trained model for image recognition
		- Developing lists for recyclable and compostable objects for text categorisation layer

## June 22

- No workshops today! Purely work kind of day
- Within improving the image recognition and classification, 
	- Went through process for re-training categories on TensorFlow demo example
	- Figured out optimization of output .pb and .txt files to load on Android
	- Identifying image sets to include in compostable list
- Tasks
	- COMPLETE
		- Added splash screen to the Android app and other UI changes
	- IN PROGRESS
		- Improving trained model for image recognition
		- Juliette managed to train the model on our giant set of objects! Took 2.5 hrs 

## June 23

- St Jean Baptiste! Day off!

## June 24

- Another day off since we're ahead of schedule

## June 25

- All the buildings on campus were locked. Annoying.
- We finally made our way to Starbucks to work, thank god for Starbucks
- Where we're at:
	- Have the newly trained model
	- Works on TensorFlow for Poets Android App
		- Continuous object recognition / detection rather than button push
	- Does not work on our version... why? SAD!
- Remaining Steps:
	- Make compatible with our version of app OR modify TensorFlow for Poets Android App 
	- Record demo video for presentation
	- Make presentation
- Schedule
	- Monday: 
		- Check in with Angelique
		- Record demo of app with first trained
			- JT: Orange, plastic waterbottle, paper towel
			- Isabella: Tea bag
			- Juliete: Bread
		- Train another graph with more images
	- Tuesday:
		- Test new graph
		- Investigate changes in confidence percentages
		- Record demo of app
	- Wednesday:
		- Make / finish presentation
	- Thursday:
		- Practice, present!

## June 26 

- Check in speaking points:
	- Project recap - image recognition app for trash sorting into recycling, compost, garbage
	- One week ago:
		- Research on other implementations, available tools
		- Identified features we wanted in the app
		- Broke project down into smaller tasks
		- Sketched out timeline
	- Since then:
		- Lots of debugging! 
		- Met every day except Fri/Sat
		- Recap at beginning, summary and next steps at end of each session
		- Progress tracking on Github document
	- Where our app is at:
		- Achieved minimum viable product yesterday
		- Android app that spits out category and confidence level
		- Retrained with our own categories on Inception V3
	- What's left:
		- Continue investigating improvements to and scaling of the classifier's object recognition
		- Work on the presentation
	- Happy to take questions on how we implemented the features or you can wait until the final presentation!
- 
