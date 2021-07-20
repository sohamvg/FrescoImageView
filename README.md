# Fresco-ImageView

FrescoImageView is an image control for the Android platform that can asynchronously load network pictures, project resources and local pictures, and supports two-finger zoom, basic image processing, and all the features of Fresco.

The control is based on Facebook's image loading library Fresco package, all methods and properties of Fresco can be used.

Fresco-ImageView itself inherits from DraweeView, so you can directly use it as DraweeView. In addition to using the loading method encapsulated by the control, you can also load pictures through Fresco's original ImageRequest.

## Features
 * Directly inherit Fresco's DraweeView, which is essentially a View, and is compatible with all Fresco's parameters and methods
 * Only one step is required to load pictures, no complicated settings are required
 * Supports two-finger zoom, and supports click events, instead of PhotoView controls

Project site： <https://github.com/HomHomLin/FrescoImageView>.

Latest version: v1.3.0

## Import project

**Gradle dependency:**
``` groovy
compile 'homhomlin.lib:frescoimageview:1.3.0'
```

or

**Maven dependency:**
``` xml
<dependency>
  <groupId>homhomlin.lib</groupId>
  <artifactId>frescoimageview</artifactId>
  <version>1.3.0</version>
</dependency>
```


## Usage

### Import Fresco

After importing FrescoImageView into the project, you also need to import Fresco, as follows:

``` groovy
compile 'com.facebook.fresco:fresco:0.10.0'
```

As of the time of writing the current Readme, the latest version of Fresco is 0.10.0.

FrescoImageView itself does not include Fresco, if you still need OKHTTP please refer to Fresco usage or see this [DEMO](https://github.com/HomHomLin/FrescoImageView/blob/master/app/src/main/java/com/lhh/frescoimageview/demo/App.java).

Fresco-0.10.0 is different from the previous version. It separates the GIF and WEBP libraries, so if your project uses Fresco-0.10.0 and requires FrescoImageView to implement the gif and webp functions, please add the following dependencies:

``` groovy
compile 'com.facebook.fresco:animated-webp:0.10.0'
compile 'com.facebook.fresco:animated-gif:0.10.0'
```

If you need Android 2.3 to implement Gif, you need to add additional dependencies:

``` groovy
compile 'com.facebook.fresco:animated-base-support:0.10.0'
```

### Configure Fresco

Add network access permissions in the AndroidManifest.xml of the project (depending on requirements). OkHttp is used in the example. Please refer to the example if you need it.

```xml
<uses-permission android:name="android.permission.INTERNET"/>
```

Configure Fresco in the Application class of the project. This is actually the content of Fresco.

``` java
public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
```

### Adding controls to XML

Add components to the interface xml that needs to be added.

FrescoImageView provides two components, FrescoImageView (common control) and FrescoZoomImageView (scalable control). Add controls as needed. Take FrescoZoomImageView as an example:

``` xml
<lib.lhh.fiv.library.FrescoZoomImageView
    android:id="@+id/fiv"
    fresco:actualImageScaleType="fitCenter"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>
```

Find the component in the code.

```java
FrescoZoomImageView frescoImageView = (FrescoZoomImageView)findViewById(R.id.fiv);
```

### Load network pictures

Call the void loadView(String url, int defaultResID) method.

url represents the address of the network image that needs to be loaded, and defaultResID represents the placeholder image (default image).

```java
frescoImageView.loadView(mImgUrl,R.mipmap.ic_launcher);
```

If you need to display the default image first, then load and display a low-resolution image, and finally display the original image, you can use the void loadView(String lowUrl ,String url, int defaultResID) method, and lowUrl represents the low-resolution image address.

### Load local images

Call the void loadLocalImage(String path, int defaultRes) method.

path represents the absolute path of the local image.

```java
frescoImageView.loadLocalImage(path,R.mipmap.ic_launcher);
```

### Load project resources

Choose any of the above methods and fill in the non-defaultResId parameter as null.

```java
frescoImageView.loadLocalImage(null,R.mipmap.ic_launcher);
```

### Click to listen

If you are using FrescoZoomImageView, you need to call the setOnDraweeClickListener(OnClickListener l) method to set up the click event listener.

If you are using FrescoImageView, you can directly use setOnClicklistener(OnClickListener l).

### Turn on and off gif animation

If your picture is of gif type, we can control the Gif animation of FrescoImageView, which is controlled by setAnim(boolean anim) of FrescoImageView. By default, we turn on animation.

### Set the circle

If you need to turn the displayed picture into a circle, you can use the asCircle() method.

```java
frescoImageView.asCircle ();
```

### Gif picture is set as a circle

Because of Fresco, if you need to set the gif to a circle, you need to use the setCircle(int overlay_color) method, and overlay_color is the background image color.

```java
frescoImageView.setCircle(Color.WHITE);
```

### Set rounded corners

Through the setCornerRadius (float radius) method, and pass in the required angle to realize the round and corner cutting.

```java
frescoImageView.setCornerRadius (10);
```

### Set up the image processor

You may need to do additional processing on the picture, then you can write a Fresco PostProcessor and set a processor through the setPostProcessor(PostProcessor) method.

```java
frescoImageView.setPostProcessor(postProcessor);
```

### Set whether to click to retry loading

Sometimes the picture will fail to load. At this time, you can set whether to allow the user to click on the picture to retry the load. SetTapToRetryEnabled(boolean tapToRetryEnabled) method.

```java
frescoImageView.setTapToRetryEnabled(true);
```

### Set picture border

Set by the setBorder(int color, float width) method.

```java
frescoImageView.setBorder(Color.BLACK, 3.0f);
```

### Clear image fillet attributes

Maybe you have set the rounded corner properties of the picture, you can clear them through the clearRoundingParams() method to restore to the initial state.

```java
frescoImageView.clearRoundingParams ();
```

### Set up loading monitor

Sometimes we want to monitor the picture loading situation, through the setControllerListener (ControllerListener controllerListener) method can add monitoring.

You can create a listener by ControllerListener controllerListener = new BaseControllerListener().

```java
frescoImageView.setControllerListener(controllerListener);
```

### other

FrescoImageView is based on the Fresco package, so the usage of Fresco is also applicable to FrescoImageView.

Similarly, FrescoZoomImageView also supports the api and Fresco methods mentioned above.

For details, please see Fresco: [Fresco's Github](https://github.com/facebook/fresco)

## Developed By

 * Linhonghong - <linhh90@163.com>

## License
Copyright 2016 LinHongHong

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
