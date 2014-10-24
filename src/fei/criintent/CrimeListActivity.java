package fei.criintent;

import android.support.v4.app.Fragment;

public class CrimeListActivity extends SingleFragmentActivity implements CrimeListFragment.Callbacks{

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
    @Override
    protected int getLayoutResId() {
    	return R.layout.activity_masterdetail;
    }
	public void onCrimeSelected(Crime crime) {
		// TODO Auto-generated method stub
		
	}
}
