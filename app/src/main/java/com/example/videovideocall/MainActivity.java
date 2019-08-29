package com.example.videovideocall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.vidyo.VidyoClient.Connector.Connector;
import com.vidyo.VidyoClient.Connector.ConnectorPkg;

public class MainActivity extends AppCompatActivity implements Connector.IConnect {
    private Connector vc;
    private FrameLayout videoFrame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectorPkg.setApplicationUIContext(this);
        ConnectorPkg.initialize();
        videoFrame = (FrameLayout)findViewById(R.id.videoFrame);
    }

    public void Start(View v) {
        startActivity(new Intent(this,NestedFragment.class));
        //vc = new Connector(videoFrame, Connector.ConnectorViewStyle.VIDYO_CONNECTORVIEWSTYLE_Default, 15, "warning info@VidyoClient info@VidyoConnector", "", 0);
        //vc.showViewAt(videoFrame, 0, 0, videoFrame.getWidth(), videoFrame.getHeight());
    }

    public void Connect(View v) {
        String token = "cHJvdmlzaW9uAHVzZXIxQGY3NWNkMy52aWR5by5pbwA2MzczMzM1OTkxOQAAYzRjZmMxYzFiMTI2YmNhNDNiOTBiODhhMTFhMzZmMzVkMmI3N2MwMDI1MjI5ZmI0MGZiY2ViZWZmOWJhMWMxNmNlMDQ0Y2Y5ZmQwZTExYmUwODAxZGE4ZjQwZDcyNzVj";
        vc.connect("prod.vidyo.io", token, "DemoUser", "DemoRoom", this);
    }

    public void Disconnect(View v) {
        vc.disconnect();
    }

    public void onSuccess() {}

    public void onFailure(Connector.ConnectorFailReason reason) {}

    public void onDisconnected(Connector.ConnectorDisconnectReason reason) {}
}
