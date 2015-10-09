# EditTextFocusTest关于EditText获取/失去焦点

1 想要知道我们的对某个控件焦点的设置有咩有变化，可以通过设置监听焦点改变监听器，重写onFocusChange。
2.当仅设置setFoucusable时候，在他false后，就再也不能获得它的焦点了。也就是从此失去了焦点，例如下面的 ，如果都把去掉，点击image2 再也不会去打印focus.

3.当只设置setFocusInTouchmode时候，那么点击image  怎么也不会打印 not focus，也就是再也不能去改变焦点。
所以要能保证能够自由切换获取焦点/失去焦点，在设置获取焦点时候一定要
mText.setFocusable(true);
 mText.setFocusableInTouchMode(true);
同时设置，
在设置失去焦点时候，设置了mText.setFocusable(false);则该view已经不能获得焦点，所以后面再加上clearFocus根本就没有用，但是如果在mText.setFocusable(false)前先clearFocus，那么点击image可以看到如下打印。所以clearFocus是清除该view 的焦点，同时，它会将焦点移给从顶开始第一个可以获得焦点的view，when a View clears focus the framework is trying to give focus to the first focusable View from the top而因为我们的布局第一个可以获得焦点的刚好是该EditText，所以该view放弃了焦点后又被动的获取了焦点，所以先打印了not focused再打印了focused\

我们还可以这样验证，在该EditText前再加个EditText，并对新加的EditText设置焦点变化监听器，可以看到mText.clearFocus时候，焦点被新加入的EditText获取了焦点。

注意，这里是从整个布局的顶部开始，不是从放弃焦点的该view所在的layout，例如，我们再把整体的布局变成2个layout,再原有基础之前上加上新的一层线性布局，可以看到，焦点移到新加入的这层顶部布局里的eidtView了。
