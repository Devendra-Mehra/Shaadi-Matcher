<img src="/assets/logo.png" align="right" />

# Shaadi-Matcher <img src="/assets/Build with love.svg"/><br>
> Shaadi-Matcher is a sample app that showcases the use of MVP architecture to build maintainable & scalable Android apps.<br>
<img src="/assets/studio version.svg"/> <img src="/assets/minSdk.svg"/> <img src="/assets/compileSdk.svg"/> <img src="/assets/gradle version.svg"/> <img src="/assets/java version.svg"/>
## What does it do?
It is a very straightforward app with a monolith screen.
<br>The screen displays a list of users matched for you & clicking on the decline it removes the match from your list and on connects it connect you to the particular user.
## Appearance?
<p align="center">
  <img src="/assets/snap.jpg" alt="Screenshots"  height="650" width="300"/>
</p>

## Architecture
This app follows the **Model-View-Presenter** architecture to quickly get an overview of MVP and how it fits in the Android world [click here](https://android.jlelse.eu/android-mvp-for-beginners-25889c500443)<br>
This app essentially serve the **Single responsibility** principle [read here](https://en.wikipedia.org/wiki/Single_responsibility_principle).

## Architecture Package Structure
> app
>> main user list
>>> contract<br>
>>> model<br>
>>> presenter<br>
>>> view<br>

## Data Source
All of the Users data is fetched from [RandomUserAPI](https://randomuser.me/).


## Interesting things to lookout for
* **Stetho** - This is one of the libraries I add to every new project I create. Stetho makes `DEBUGGING` super simple.
* **Data Binding** - If you are still writing boilerplate code to bind views yourself, you need to checkout [DataBinding](https://developer.android.com/topic/libraries/data-binding/index.html) right now. Personally, I use it to just bind the views as I am against the idea of adding logic to `XMLs`, but DataBinding can do a lot more than just bind views.
* **Vector Drawables** - `STOP` using multiple versions of the same image to support the different density buckets. Enable [Vector Drawables](https://developer.android.com/guide/topics/graphics/vector-drawable-resources.html) in your app-level `build.gradle` and start using them to reduce the size of the `APK` and also your work of creating/managing versions of the same image.
* **Screener** - Create wonderful screenshots with just a few clicks on your Android phone. Click [here](https://play.google.com/store/apps/details?id=de.toastcode.screener&hl=en) to download the app.


### Libraries Used
* [Support Library](https://developer.android.com/topic/libraries/support-library/index.html)
* [Retrofit](http://square.github.io/retrofit/)
* [OkHttp](http://square.github.io/okhttp/)
* [Gson](https://github.com/google/gson)
* [Picasso](http://square.github.io/picasso/)
* [Stetho](http://facebook.github.io/stetho/)

## License
```
Copyright 2019 Devendra Mehra

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
