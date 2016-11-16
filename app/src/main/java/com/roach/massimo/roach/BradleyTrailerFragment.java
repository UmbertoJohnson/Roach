package com.roach.massimo.roach;

import android.app.Fragment;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by sweet on 2016-05-30.
 */
public class BradleyTrailerFragment extends Fragment{

    View myView;
    private VideoView videoView1;
    private VideoView videoView2;
    private int position = 0;
    private MediaController mediaController1;
    private MediaController mediaController2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.bradley_trailer, container, false);

        videoView1 = (VideoView) myView.findViewById(R.id.video1);
        videoView2 = (VideoView) myView.findViewById(R.id.video2);

        // Set the media controller buttons
        if (mediaController1 == null) {
            mediaController1 = new MediaController(getActivity());

            // Set the videoView1 that acts as the anchor for the MediaController.
            mediaController1.setAnchorView(videoView1);


            // Set MediaController for VideoView
            videoView1.setMediaController(mediaController1);
        }

        // Set the media controller buttons
        if (mediaController2 == null) {
            mediaController2 = new MediaController(getActivity());

            // Set the videoView1 that acts as the anchor for the MediaController.
            mediaController2.setAnchorView(videoView2);


            // Set MediaController for VideoView
            videoView2.setMediaController(mediaController2);
        }


        try {
            // ID of video file.
            int id1 = this.getRawResIdByName("bradleyfield");
            int id2 = this.getRawResIdByName("bradley_suicide");
            videoView1.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + id1));
            videoView2.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + id2));

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }



        // When the video file ready for playback.
        videoView1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            public void onPrepared(MediaPlayer mediaPlayer) {


                videoView1.seekTo(position);

                // When video Screen change size.
                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {

                        // Re-Set the videoView1 that acts as the anchor for the MediaController
                        mediaController1.setAnchorView(videoView1);
                    }
                });
            }
        });

        // When the video file ready for playback.
        videoView2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            public void onPrepared(MediaPlayer mediaPlayer) {


                videoView2.seekTo(position);

                // When video Screen change size.
                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {

                        // Re-Set the videoView1 that acts as the anchor for the MediaController
                        mediaController2.setAnchorView(videoView2);
                    }
                });
            }
        });
        return myView;
    }

    // Find ID corresponding to the name of the resource (in the directory raw).
    public int getRawResIdByName(String resName) {
        String pkgName = getActivity().getPackageName();
        // Return 0 if not found.
        int resID = this.getResources().getIdentifier(resName, "raw", pkgName);
        Log.i("AndroidVideoView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }

    // When you change direction of phone, this method will be called.
    // It store the state of video (Current position)
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        // Store current position.
        savedInstanceState.putInt("CurrentPosition", videoView1.getCurrentPosition());
        videoView1.pause();
    }
}
