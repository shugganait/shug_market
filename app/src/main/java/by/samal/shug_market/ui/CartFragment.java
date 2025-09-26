package by.samal.shug_market.ui;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import by.samal.shug_market.base.BaseFragment;
import by.samal.shug_market.databinding.FragmentCartBinding;

public class CartFragment extends BaseFragment<FragmentCartBinding> {
    @Override
    protected FragmentCartBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentCartBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void uiBox() {
///
    }
}