package com.yangpf.xdroidmvp.M;




import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Streaming;
import retrofit2.http.Url;


/**
 * Created by Administrator on 2018/6/18 0018.
 */

public interface DownloadService {
    @GET
    Observable<ResponseBody> downLoadImg(String fileUrl);

}
