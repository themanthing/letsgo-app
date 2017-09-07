package ru.mobilesoft.piligram.ui.fragments.registration;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.ui.fragments.BaseWizardFragment;
import su.ias.components.selimg.Selimg;
import su.ias.components.selimg.callbacks.PhotoFileCallback;
import su.ias.components.selimg.providers.ImageProvider;

/**
 * Created on 8/14/17.
 */

public class EnterAvatarFragment extends BaseWizardFragment implements PhotoFileCallback {

    private static final String KEY_AVATAR = "avatar";
    @BindView(R.id.iv_avatar)
    ImageView avatar;
    private File avatarLink;

    @Override
    protected int getLayout() {
        return R.layout.fragment_reg_avatar;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (actionButton != null) {
            actionButton.setText(R.string.done);
            actionButton.setEnabled(true);
        }
    }

    @OnClick(R.id.select_avatar)
    void onAvatarSelectClick() {
        Selimg.getInstance()
                .type(ImageProvider.TYPE_FROM_CAMERA)
                .type(ImageProvider.TYPE_FROM_GALLERY)
                .file(this)
                .useFrontCamera()
                .showWith(getActivity().getSupportFragmentManager());
    }

    @Override
    public void onFileSelected(File file) {
        // а вот тут вот надо подтянуть его
        avatarLink = file;
        Glide.with(getActivity()).load(file).into(avatar);
    }

    @Override
    public void onFileNotSelected() {
        // ну не выбрали и фиг с ним
    }

    @Override
    protected boolean validate() {
        return true;
    }

    @Override
    protected void saveValue() {
        if (avatarLink != null) {
            wizard.setValue(KEY_AVATAR, avatarLink);
        }
    }

    @Override
    protected void loadValue() {
        if (wizard.containsKey(KEY_AVATAR)) {
            onFileSelected((File) wizard.getValue(KEY_AVATAR));
        }
    }
}
