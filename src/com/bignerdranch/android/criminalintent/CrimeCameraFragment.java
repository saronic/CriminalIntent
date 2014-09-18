package com.bignerdranch.android.criminalintent;

import android.hardware.Camera;
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
}
