package com.bignerdranch.android.criminalintent;

import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class CrimeCameraFragment extends Fragment {
	private Camera mCamera;
	private SurfaceView mSurfaceView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_crime_camera, container, false);
		Button takePicButton = (Button) v.findViewById(R.id.crime_camera_takePictureButton);
		takePicButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View view) {
				getActivity().finish();
				
			}
		});
		
		mSurfaceView = (SurfaceView) v.findViewById(R.id.crime_camera_surfaceView);
		
		return v;
	}
	
	@Override
	public void onResume() {
		super.onResume();
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD) {
			mCamera = Camera.open(0);
		} else {
			mCamera = Camera.open();
		}
	}
	
	@Override
	public void onPause() {
		super.onPause();
		if (mCamera != null) {
			mCamera.release();
			mCamera = null;
		}
	}
}
