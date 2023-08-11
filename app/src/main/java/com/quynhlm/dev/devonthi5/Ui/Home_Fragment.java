package com.quynhlm.dev.devonthi5.Ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.quynhlm.dev.devonthi5.Adapter.SinhVien_Adapter;
import com.quynhlm.dev.devonthi5.Dao.SinhVienDao;
import com.quynhlm.dev.devonthi5.Model.SinhVien;
import com.quynhlm.dev.devonthi5.R;
import java.util.ArrayList;

public class Home_Fragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<SinhVien> list = new ArrayList<>();
    private SinhVienDao sinhVienDao;
    private SinhVien_Adapter sinhVienAdapter;

    private String customTag;

    public void setCustomTag(String customTag) {
        this.customTag = customTag;
    }

    public String getCustomTag() {
        return customTag;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.RecyclerView);
        setUpRecyclerView();

        view.findViewById(R.id.fab_add).setOnClickListener(v -> showAddSinhVienDialog());

        return view;
    }

    private void setUpRecyclerView() {
        sinhVienDao = new SinhVienDao(getContext());
        list = sinhVienDao.selectAll();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        sinhVienAdapter = new SinhVien_Adapter(getContext(), list);
        recyclerView.setAdapter(sinhVienAdapter);
    }

    private void showAddSinhVienDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.add_sinhvien, null);
        builder.setView(dialogView);

        EditText edtId = dialogView.findViewById(R.id.edt_id);
        EditText edtName = dialogView.findViewById(R.id.edt_name);
        EditText edtSinhNhat = dialogView.findViewById(R.id.edt_sinhnhat);
        EditText edtMssv = dialogView.findViewById(R.id.edt_mssv);

        builder.setPositiveButton("Add", (dialog, which) -> {
            int id = Integer.parseInt(edtId.getText().toString().trim());
            String name = edtName.getText().toString().trim();
            int sinhnhat = Integer.parseInt(edtSinhNhat.getText().toString().trim());
            String mssv = edtMssv.getText().toString().trim();
            SinhVien sinhVien = new SinhVien(id, name, sinhnhat, mssv);

            if (sinhVienDao.insertData(sinhVien)) {
                updateRecyclerView();
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void updateRecyclerView() {
        if (sinhVienDao != null) {
            list.clear();
            list.addAll(sinhVienDao.selectAll());
            sinhVienAdapter.notifyDataSetChanged();
        } else {
            Log.e("Check", "Update: " + "SinhVienDao == Null");
        }
    }
}
