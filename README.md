<img src="/assets/logo.png" align="right" />

# Shaadi-Matcher <img src="/assets/Build with love.svg"/><br>
> Shaadi-Matcher is a sample app that showcases the use of MVP architecture to build maintainable & scalable Android apps.<br>
<img src="/assets/studio version.svg"/> <img src="/assets/minSdk.svg"/> <img src="/assets/compileSdk.svg"/> <img src="/assets/gradle version.svg"/> <img src="/assets/java version.svg"/>
## What does it do?
It is a very straightforward app with a single screen.
<br>The screen displays a list of users matched for you & clicking on the decline it removes the match from your list and on connects it connect you to the particular user.
## Appearance?
<p align="center">
    <img src="/assets/snap.png" alt="Screenshots"  height="650" width="330"/>
</p>

## Architecture
This app follows the **Model-View-Presenter** architecture to quickly get an overview of MVP and how it fits in the Android world [click here](https://android.jlelse.eu/android-mvp-for-beginners-25889c500443)<br>
This app essentially serve the **Single responsibility** principle [read here](https://en.wikipedia.org/wiki/Single_responsibility_principle).

## Architecture Package Structure
> app
>> main user list
>>> contract<br>
>>> model<br>
>>> network<br>
>>> presenter<br>
>>> view<br>

This app uses a combination of `package-by-feature` and `package-by-layer`. The top level packages are feature based. Inside each `feature-package`, the code is split into different packages based on the layer.This structure has worked for me and I have been using it for some time now. Read [this](http://www.javapractices.com/topic/TopicAction.do?Id=205) blogpost to know more about packaging structures.


## Data Source
All of the Users data is fetched from [RandomUserAPI](https://randomuser.me/).

## Data Flow diagram
<img src="/assets/data flow.PNG" align="center" />


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
