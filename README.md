# InspirationalQuotesExercise
### A small Android project to practice executing network requests and parsing the network response 

This app uses the [ZenQuotes](https://premium.zenquotes.io/zenquotes-documentation/) API to generate an inspirational quote. Specifically, we will be using the https://zenquotes.io/api/random endpoint. Note that on a free account, you can only call the API 5 times every 30 seconds. Once you've reached that limit, you will no longer receive a valid response.

<img src="https://user-images.githubusercontent.com/5016806/137030637-3c62aaac-4a73-4edf-ad90-cec62b434a44.png" width="300" >

The app currently doesn't work and requires a few fixes. This exercise takes you through the steps to produce a fully working app as pictured below.

1. Clone this repo and import the project into Android Studio
2. Launch the project on your Android device or emulator. Notice that the app is crashing on launch right now!  
  a) Fix the crash by looking at the logs to see what caused the crash. (Hint: There's a TODO in ZenQuotesApiService)  
  b) See solution for fixing crash [here](https://github.com/calren/InspirationalQuotesExercise/pull/1/files)
3. Notice that unfortunately, there are still no quotes being displayed in the app. This is because the Quote class is currently incomplete. It should be parsing the JSON object for a Quote. The documentation for the response object is here: https://premium.zenquotes.io/zenquotes-documentation/#api-response. Use the documentation to complete the Quote class.  
  a) See how this is done in the Android Basics codelab on [Step 8](https://developer.android.com/codelabs/basic-android-kotlin-training-getting-data-internet?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-4-pathway-2%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-getting-data-internet#7) for the @Json Annotation section  
  b) See solution [here](https://github.com/calren/InspirationalQuotesExercise/pull/2)
4. The last step is to set up an onClickListener for the button in the app to display a new quote.  
  a) See solution [here](https://github.com/calren/InspirationalQuotesExercise/pull/3/files)
5. Bonus step: Right now the app only displays the quote. But part of the response also includes the author of the quote. Display the author of the quote along with the quote itself!
