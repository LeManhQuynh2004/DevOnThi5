package com.quynhlm.dev.devonthi5.Ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.quynhlm.dev.devonthi5.Dao.SinhVienDao;
import com.quynhlm.dev.devonthi5.Model.SinhVien;
import com.quynhlm.dev.devonthi5.R;

import java.util.ArrayList;


public class Update_Fragment extends Fragment {

    View view;

    EditText edt_id, edt_name, edt_sinhnhat, edt_mssv;

    SinhVienDao sinhVienDao;

    ArrayList<SinhVien> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_update, container, false);
        sinhVienDao = new SinhVienDao(getContext());
        Log.e("err", "onCreateView: " + "Vao update");
        edt_id = view.findViewById(R.id.edt_update_id);
        edt_name = view.findViewById(R.id.edt_update_name);
        edt_sinhnhat = view.findViewById(R.id.edt_update_sinhnhat);
        edt_mssv = view.findViewById(R.id.edt_update_mssv);
        view.findViewById(R.id.btnUpdate).setOnClickListener(view1 -> {
            int id = Integer.parseInt(edt_id.getText().toString().trim());
            String name = edt_name.getText().toString();
            int sinhnhat = Integer.parseInt(edt_sinhnhat.getText().toString().trim());
            String mssv = edt_mssv.getText().toString();
            SinhVien sinhVien = new SinhVien();
            sinhVien.setId(id);
            sinhVien.setName(name);
            sinhVien.setBirthday(sinhnhat);
            sinhVien.setMSSV(mssv);

            if (sinhVienDao.UpdateData(sinhVien)) {
                Log.e("id", "onCreateView: " + sinhVien.getId());
                Toast.makeText(getContext(), "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                edt_id.setText("");
                edt_name.setText("");
                edt_sinhnhat.setText("");
                edt_mssv.setText("");

                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                Home_Fragment homeFragment = (Home_Fragment) fragmentManager.findFragmentByTag("Danhsach");
                if (homeFragment != null) {
                    homeFragment.updateRecyclerView();
                }
            } else {
                Toast.makeText(getContext(), "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}