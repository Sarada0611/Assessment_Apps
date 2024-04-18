package com.example.listapps;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private PackageManager packageManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        packageManager = getPackageManager();

        final List<PackageInfo> installedApps = packageManager.getInstalledPackages(PackageManager.GET_PERMISSIONS);

        List<String> appNames = new ArrayList<>();
        for (PackageInfo packageInfo : installedApps) {
            appNames.add(packageInfo.applicationInfo.loadLabel(packageManager).toString());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, appNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] permissions = installedApps.get(position).requestedPermissions;
                if (permissions != null && permissions.length > 0) {
                    StringBuilder permissionList = new StringBuilder();
                    for (String permission : permissions) {
                        permissionList.append(permission).append("\n");
                    }
                    Toast.makeText(MainActivity.this, "Permissions:\n" + permissionList.toString(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "No permissions requested for this app.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
