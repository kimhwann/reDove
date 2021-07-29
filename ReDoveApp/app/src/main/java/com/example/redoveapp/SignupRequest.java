package com.example.redoveapp;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class SignupRequest extends StringRequest {

    final static private String URL ="http://team33.dothome.co.kr/php/register.php"; //서버 호스팅 주소
    private Map<String, String> map;

    public SignupRequest(String stu_name, String department, String pw, String email, int stu_num, int phone, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("stu_name", stu_name);
        map.put("department", department);
        map.put("stu_num",stu_num + "");
        map.put("pw", pw);
        map.put("email", email);
        map.put("phone",phone + "");
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
