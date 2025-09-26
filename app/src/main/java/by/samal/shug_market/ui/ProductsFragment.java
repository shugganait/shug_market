package by.samal.shug_market.ui;


import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;

import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.appbar.AppBarLayout;

import by.samal.shug_market.App;
import by.samal.shug_market.R;
import by.samal.shug_market.base.BaseFragment;
import by.samal.shug_market.data_base.DataBase;
import by.samal.shug_market.databinding.FragmentProductsBinding;

public class ProductsFragment extends BaseFragment<FragmentProductsBinding> {

    private NavController navController;
    private boolean isCollapsed = false;

    @Override
    protected FragmentProductsBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentProductsBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void uiBox() {
        navController = Navigation.findNavController(getBinding.getRoot());
        initListeners();
    }

    private void initListeners() {
        getBinding.btnCart.setOnClickListener(v -> {
//            if (isInCart) {
            navController.navigate(R.id.cartFragment);
//            } else {
//                insertCart()
//                setBtnCartNewStatus()
//            }
        });

        collapsingToolbarListener();
    }

    private void collapsingToolbarListener() {
        getBinding.appBar.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            int scrollRange = appBarLayout.getTotalScrollRange();
            float alpha = 1.0f - Math.abs(verticalOffset / (float) scrollRange);
            getBinding.imgLogo.setAlpha(alpha);

            if (Math.abs(verticalOffset) >= scrollRange) {
                if (getActivity() != null && getActivity().getWindow() != null) {
                    Window window = getActivity().getWindow();
                    window.setStatusBarColor(ContextCompat.getColor(requireContext(), R.color.grey_average));
                    new WindowInsetsControllerCompat(window, window.getDecorView()).setAppearanceLightStatusBars(false);
                }
            } else {
                if (getActivity() != null && getActivity().getWindow() != null) {
                    Window window = getActivity().getWindow();
                    window.setStatusBarColor(ContextCompat.getColor(requireContext(), R.color.grey_light));
                    new WindowInsetsControllerCompat(window, window.getDecorView()).setAppearanceLightStatusBars(true);
                }
            }

            int currentHeight = scrollRange + verticalOffset;

            if (currentHeight < 152 && !isCollapsed) {
                // centering tvCategory
                isCollapsed = true;

                float translationX = getBinding.products.getWidth() / 2f - getBinding.tvCategory.getWidth() / 2f;
                tvMovingAnimation(translationX);
            } else if (currentHeight > 20 && isCollapsed) {
                // moving to starting position
                isCollapsed = false;
                tvMovingAnimation(0f);
            }
        });
    }

    private void tvMovingAnimation(float sum) {
        ViewCompat.animate(getBinding.tvCategory)
                .translationX(sum)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .start();
    }

    private void tvCentering(float sum) {
        ViewCompat.animate(getBinding.tvCategory)
                .setDuration(0)
                .translationX(sum)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .start();
    }


}