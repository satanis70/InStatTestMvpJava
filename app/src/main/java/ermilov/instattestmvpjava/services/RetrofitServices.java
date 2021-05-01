package ermilov.instattestmvpjava.services;

import com.google.gson.JsonObject;

import java.util.List;

import ermilov.instattestmvpjava.models.matchinfomodels.MatchModel;
import ermilov.instattestmvpjava.models.videostreammodel.VideoStreamModel;
import io.reactivex.rxjava3.core.Flowable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RetrofitServices {
    @POST("data")
    @Headers("Content-Type: application/json")
    Flowable<MatchModel.Root> getMatchInfo(@Body JsonObject body);

    @POST("video-urls")
    @Headers("Content-Type: application/json")
    Flowable<List<VideoStreamModel>> getVideoStreamApi(@Body JsonObject body);
}
