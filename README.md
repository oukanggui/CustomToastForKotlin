# CustomToastForKotlin
A simple custom Toast with Kotlin
# How to use ?
```java
 var toastHelper = ToastHelper(context)
 //toastHelper.setView(R.layout.toast_custom)
 //If you don't want to use the default layout(R.layout.toast_custom) for the toast,
 //you need to call setView() mothed to set the custom view for the Toast before calling setText() and setImage motheds.
 //Also,the custom layout must contain the id @+id/toast_icon for ImageView and the id @+id/toast_message for TextView
 toastHelper.setText("I am baymax from custom toast")
 toastHelper.show()
 ```
