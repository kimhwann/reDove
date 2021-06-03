package com.example.redoveapp;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {

    final static private String URL ="http://team33.dothome.co.kr/Login.php"; //서버 호스팅 주소
    private Map<String, String> map;

    public LoginRequest(int stu_num,  String pw, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("stu_num",stu_num + "");
        map.put("pw",pw);
    }

    @Override
    protected Map<String, String> getPostParams() throws AuthFailureError {
        return map;
    }
}
