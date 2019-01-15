package bwei.com.day7_rikao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;

public class ScanActivity extends AppCompatActivity implements QRCodeView.Delegate {

    @BindView(R.id.zxing)
    ZXingView zxing;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        unbinder = ButterKnife.bind(this);
        zxing.setDelegate(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        zxing.startCamera();
        zxing.startSpotAndShowRect();
        zxing.openFlashlight();
    }

    @Override
    public void onScanQRCodeSuccess(String result) {

    }

    @Override
    public void onCameraAmbientBrightnessChanged(boolean isDark) {

    }

    @Override
    public void onScanQRCodeOpenCameraError() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        zxing.stopCamera();
    }
}
