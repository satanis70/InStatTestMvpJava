package ermilov.instattestmvpjava.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;

import ermilov.instattestmvpjava.R;
import ermilov.instattestmvpjava.models.videostreammodel.VideoStreamModel;
import ermilov.instattestmvpjava.presenters.VideoStreamPresenter;
import ermilov.instattestmvpjava.views.VideoStreamView;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class VideoStreamActivity extends MvpAppCompatActivity implements VideoStreamView {

    @InjectPresenter
    VideoStreamPresenter videoStreamPresenter;
    int pos = 0;
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_stream);
        videoView = findViewById(R.id.video_view);
        videoStreamPresenter.requestApi();
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);


        if (savedInstanceState != null) {
            pos = savedInstanceState.getInt("pos");
        }


    }

    @Override
    public void onCompleteVideoStream(ArrayList<VideoStreamModel> videoStreamModel) {
        videoView.setVideoURI(Uri.parse(videoStreamModel.get(0).getUrl()));
        videoView.setMediaController(new MediaController(this));
        videoView.requestFocus(0);
        videoView.seekTo(pos);
        videoView.start();
    }

    @Override
    public void onErrorVideoStream(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("pos", videoView.getCurrentPosition());
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
