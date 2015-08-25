package kimxu.model;

import kimxu.volley.VolleyError;

/**
 * Created by xuzhiguo on 15/8/25.
 */
public class KObject extends IKObject{
    public KObject(VolleyError error,int request) {
        this.error=error;
        //错误
        this.request=request;
    }
    public KObject(Object obj,int request) {
        this.obj = obj;
        this.request=request;

    }

}
