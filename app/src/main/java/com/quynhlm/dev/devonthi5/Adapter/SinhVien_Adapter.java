package com.quynhlm.dev.devonthi5.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.quynhlm.dev.devonthi5.Dao.SinhVienDao;
import com.quynhlm.dev.devonthi5.Model.SinhVien;
import com.quynhlm.dev.devonthi5.R;

import java.util.ArrayList;

public class SinhVien_Adapter extends RecyclerView.Adapter<SinhVien_Adapter.SinhVienViewHolder> {

    Context context;
    ArrayList<SinhVien> list;

    SinhVienDao sinhVienDao;

    public SinhVien_Adapter(Context context, ArrayList<SinhVien> list) {
        this.context = context;
        this.list = list;
        sinhVienDao = new SinhVienDao(context);
    }

    @NonNull
    @Override
    public SinhVienViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sinhvien, parent, false);
        return new SinhVienViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SinhVienViewHolder holder, int position) {
        holder.txt_id.setText(list.get(position).getId() + "");

        holder.txt_name.setText(list.get(position).getName());

        holder.txt_mssv.setText(list.get(position).getMSSV());

        holder.txt_sinhnhat.setText(list.get(position).getBirthday() + "");

        holder.img_Delete.setOnClickListener(view -> {
            DeleteItem(position);
        });
    }

    private void DeleteItem(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Thong bao");
        builder.setMessage("ban co chac chan muon xoa sinh vien nay khong");
        builder.setPositiveButton("Xoa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                SinhVien sinhVien = list.get(position);
                if (sinhVienDao.DeleteData(sinhVien)) {
                    Toast.makeText(context, "Xoa thanh cong", Toast.LENGTH_SHORT).show();
                    list.remove(sinhVien);
                    notifyDataSetChanged();
                } else {
                    Toast.makeText(context, "Xoa that bai", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("huy", null);
        builder.show();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class SinhVienViewHolder extends RecyclerView.ViewHolder {

        TextView txt_id, txt_name, txt_sinhnhat, txt_mssv;
        ImageView img_Delete;

        public SinhVienViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_id = itemView.findViewById(R.id.txt_id);
            txt_name = itemView.findViewById(R.id.txt_item_name);
            txt_sinhnhat = itemView.findViewById(R.id.txt_item_sinhnhat);
            txt_mssv = itemView.findViewById(R.id.txt_item_MSSV);
            img_Delete = itemView.findViewById(R.id.imgDelete);
        }
    }
}
