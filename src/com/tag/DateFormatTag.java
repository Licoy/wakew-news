package com.tag;

import com.utils.Tools;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

/*
 * Created by Licoy on 2016/12/21 0021.
 */
public class DateFormatTag extends SimpleTagSupport{
    private long time;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspFragment jf =  this.getJspBody();
        StringWriter sw = new StringWriter();//开启缓存区2
        jf.invoke(sw);

        String nowtime = Tools.dateFormatHasTime(time);
        this.getJspContext().getOut().print(nowtime);
    }
}
