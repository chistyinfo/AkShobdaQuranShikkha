package fragments;

import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.IOException;

import theoaktroop.akshobdaquranshikkha.R;


public class ThreeFragment
        extends Fragment
        implements SurfaceHolder.Callback {

    Uri targetUri = Uri.parse("android.resource://" + R.raw.small);

    MediaPlayer mediaPlayer;
    SurfaceView surfaceView;
    SurfaceHolder surfaceHolder;
    boolean pausing = false;

    TextView mediaUri;
    Button buttonPlayVideo, buttonPauseVideo;
    private  Context context;
    public ThreeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_three,container,false);
        mediaUri = (TextView)view.findViewById(R.id.mediauri);
        buttonPlayVideo = (Button)view.findViewById(R.id.playvideoplayer);
        buttonPauseVideo = (Button)view.findViewById(R.id.pausevideoplayer);
        surfaceView = (SurfaceView)view.findViewById(R.id.surfaceview);

        getActivity().getWindow().setFormat(PixelFormat.UNKNOWN);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        surfaceHolder.setFixedSize(176, 144);
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        mediaPlayer = new MediaPlayer();


        buttonPlayVideo.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {

                if(targetUri != null){

                    pausing = false;

                    if(mediaPlayer.isPlaying()){
                        mediaPlayer.reset();
                    }

                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mediaPlayer.setDisplay(surfaceHolder);

                    try {
                        mediaPlayer.setDataSource(getActivity().getApplicationContext(), targetUri);
                        mediaPlayer.prepare();
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                        Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_LONG).show();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                        Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_LONG).show();
                    }

                    mediaPlayer.start();
                }

            }});

        buttonPauseVideo.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                if(targetUri != null){
                    if(pausing){
                        pausing = false;
                        mediaPlayer.start();
                    }
                    else{
                        pausing = true;
                        mediaPlayer.pause();
                    }
                }
            }});
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context=activity;

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
