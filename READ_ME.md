**SafeData**

Android 数据保密

**V1.0.0**

```
SafeSP   (SharedPreferences 数据加密)
```

``` 
SafeFile (File 数据加密)
```

```
SafeDirManager (分区管理)
```


Exp:

```
//SafeSP
SafeSP("FileName").build().edit()
    .putString("DataKey", inputEt.text.toString())
    .apply()

//保存图片
val pic = Bitmap.createBitmap(contentTv.width, contentTv.height, Bitmap.Config.ARGB_8888)
            contentTv.draw(Canvas(pic))
            picPath = applicationContext.cacheDir.absolutePath + "${System.currentTimeMillis()}.png"
            SafeFile(applicationContext).savePic(picPath, pic)
```

**V1.1.0**
```
DataStore 数据扩展
```