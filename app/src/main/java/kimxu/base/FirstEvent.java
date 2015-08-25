package kimxu.base;

import kimxu.model.IKObject;
import kimxu.model.KObject;

public class FirstEvent extends IKObject{
    private String msg;
    public FirstEvent(KObject object) {
      msg = (String) object.obj;
    }
    public String getMsg()
    {
        return msg;
    }

}