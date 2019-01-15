package bwei.com.day7_rikao.Utils;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OKHttps {
    private   static volatile   OKHttps  instance;
    private static OkHttpClient okHttpClient;
    private static Request request;
    private static RequestBody builder;
    //创建拦截其方法
    private   static Interceptor getInterceptor(){
        Interceptor  interceptor=new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request  request=chain.request();
                Log.i("++++","拦截前");
                Response  response  =chain.proceed(request);
                Log.i("++++","拦截后");
                return response;
            }
        };
        return interceptor;
    }
    private  OKHttps(){
        File  file=new File(Environment.getExternalStorageDirectory(),"cach11");
        okHttpClient=new OkHttpClient().newBuilder()
                .readTimeout(3000, TimeUnit.SECONDS)
                .connectTimeout(3000,TimeUnit.SECONDS)
                .addInterceptor(getInterceptor())
                .cache(new Cache(file,10*1024))
                .build()
        ;
    }
    public   static   OKHttps  getInstance(){
        if(instance==null){
            synchronized (OKHttps.class){
                if(null==instance){
                    instance=new OKHttps();
                }

            }
        }
        return  instance;
    }
    /*
     * okhttp get异步请求方法
     * */
    public static void  OkHttpget(String url, Callback callss){
        //创建okHttpClient
        okHttpClient = new OkHttpClient()
        ;
        //创建request
        request = new Request.Builder().url(url).method("GET",null).build();
        //
        okHttpClient.newCall(request).enqueue(callss);
    }
    //okhttp post请求
    public static  void OkHttpPost(String url,String name,String pswd ,Callback call){
        okHttpClient = new OkHttpClient();
        builder = new FormBody.Builder()
                .add("phone",name)
                .add("pwd",pswd)
                .build();
        //创建request
        request = new Request
                .Builder()
                .url(url)
                .post(builder)
                .build();
        okHttpClient.newCall(request).enqueue(call);
    }
}
