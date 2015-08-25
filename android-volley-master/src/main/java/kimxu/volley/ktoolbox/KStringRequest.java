package kimxu.volley.ktoolbox;

import java.io.UnsupportedEncodingException;

import kimxu.event.EventBus;
import kimxu.model.KObject;
import kimxu.volley.NetworkResponse;
import kimxu.volley.Request;
import kimxu.volley.Response;
import kimxu.volley.toolbox.HttpHeaderParser;

public class KStringRequest extends Request<String> {
    private int request;

    public KStringRequest(int method, String url, final int request) {
        super(method, url,request);
        this.request = request;
    }

    public KStringRequest(String url, int request) {
        this(Method.GET, url, request);
    }

    @Override
    protected void deliverResponse(String response) {
        EventBus.getDefault().post(new KObject(response,request));
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        String parsed;
        try {
            parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        } catch (UnsupportedEncodingException e) {
            parsed = new String(response.data);
        }
        return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
    }
}
