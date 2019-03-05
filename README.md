# HorizontalProgressBar
### 带百分比进度显示、可自定义文字颜色大小、进度条颜色高度的水平进度条
---
### demo
![效果图](https://github.com/fengfeilong0529/HorizontalProgressBar/blob/master/pics/HorProgressBar.png "feilong")

![动图](https://github.com/fengfeilong0529/HorizontalProgressBar/blob/master/pics/Animation.gif "feilong")
---
### 扫码下载demo
![scan](https://github.com/fengfeilong0529/HorizontalProgressBar/blob/master/pics/%E4%B8%8B%E8%BD%BD.png "feilong")
### 链接：[下载](https://fir.im/ypgc)

## 使用步骤
Step 1. Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.fengfeilong0529:HorizontalProgressBar:v1.0'
	}
  
Step 3. Add in xml

 <com.feilong.horizontalporgressbar.HorProgressView
        android:id="@+id/horProcessView3"
        android:layout_width="200dp"
        android:layout_height="30dp"
        app:processColor="@color/colorPrimary"
        app:processTextColor="#fff"
        app:processTextSize="14sp"
        app:barWidth="12dp"/>

        

