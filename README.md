# LetterListDemo
字母列表测试，根据首字母显示对应图标
项目中会遇到有时候列表要按照内容的首字母来进行显示加载相应的字母ICON，我觉得这样实现的关键代码是创建资源加载的方法，避免重复的操作

    /***
     * 根据传入的字母获取相应的Icon的资源引用
     * @param letter   传入的字母，小写，因为资源文件只支持小写
     * @return  对应的资源引用
     */
    private int getIconResId(char letter){
        // 将传入的大写转换为小写，并得到对应的资源文件ID返回
        if(Character.isLetter(letter)){
            return this.getResources().getIdentifier("icon_"+Character.toLowerCase(letter),"mipmap",getPackageName());
        }
        return R.mipmap.ic_launcher;
    }
