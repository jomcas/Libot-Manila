package com.example.manila;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LandmarksAdapter extends RecyclerView.Adapter<LandmarksAdapter.ViewHolder> {
    private ArrayList<Landmarks> landmarks;
    private DatabaseHelperForUsers mydb;

    public LandmarksAdapter(Context context,ArrayList<Landmarks> list){
        landmarks=list;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView Icons;
        TextView Title;
        TextView Details;
        ImageView Status;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Title=itemView.findViewById(R.id.TextViewTitle);
            Details=itemView.findViewById(R.id.TextViewDetails);
            Icons=itemView.findViewById(R.id.ImageViewRizal);
            Status = itemView.findViewById(R.id.ivVisited);
        }
    }

    @NonNull
    @Override
    public LandmarksAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LandmarksAdapter.ViewHolder holder, int position) {

        holder.itemView.setTag(landmarks.get(position));
        holder.Title.setText(landmarks.get(position).getLandmarks());
        holder.Details.setText(landmarks.get(position).getID());
//        holder.Status.setTag(landmarks.get(position));

//        int landmarkID = mydb.getIDFromTableLandmarks(landmarks.get(position).getLandmarks());
//
//        if(landmarkID != 0) {
//            // not on list muna
//            holder.Status.setImageResource(R.drawable.visited);
//        } else {
//            // lister
//            holder.Status.setImageResource(R.drawable.listed);
//        }

        if(landmarks.get(position).getPreferences().equals("National Planetarium")){
            holder.Icons.setImageResource(R.drawable.planetarium);
        }else if(landmarks.get(position).getPreferences().equals("National Museum of Natural History")){
            holder.Icons.setImageResource(R.drawable.history);
        }else if(landmarks.get(position).getPreferences().equals("National Museum of Anthropology")){
            holder.Icons.setImageResource(R.drawable.annthropology);
        }else if(landmarks.get(position).getPreferences().equals("National Museum of Fine Arts")){
            holder.Icons.setImageResource(R.drawable.finearts);
        }else if(landmarks.get(position).getPreferences().equals("Museo ni Jose Rizal")){
            holder.Icons.setImageResource(R.drawable.rizal);
        }else if(landmarks.get(position).getPreferences().equals("Intramuros, Fort Santiago")){
            holder.Icons.setImageResource(R.drawable.intram);
        }else if(landmarks.get(position).getPreferences().equals("Rizal Park")){
            holder.Icons.setImageResource(R.drawable.rizalpark);
        }else if(landmarks.get(position).getPreferences().equals("Paco Park")){
            holder.Icons.setImageResource(R.drawable.pacopark);
        }else if(landmarks.get(position).getPreferences().equals("Manila Ocean Park")){
            holder.Icons.setImageResource(R.drawable.manilaocean);
        }else if(landmarks.get(position).getPreferences().equals("San Agustin Church")){
            holder.Icons.setImageResource(R.drawable.sanagustin);
        }else if(landmarks.get(position).getPreferences().equals("Quiapo Church")){
            holder.Icons.setImageResource(R.drawable.quaipo);
        }else if(landmarks.get(position).getPreferences().equals("Manila Cathedral")){
            holder.Icons.setImageResource(R.drawable.manilacathedral);
        }else if(landmarks.get(position).getPreferences().equals("China Town")){
            holder.Icons.setImageResource(R.drawable.binondo);
        }else if(landmarks.get(position).getPreferences().equals("Divisoria")){
            holder.Icons.setImageResource(R.drawable.divisoria);
        }else if(landmarks.get(position).getPreferences().equals("Bahay Tsino")){
            holder.Icons.setImageResource(R.drawable.bahaytsino);
        }else if(landmarks.get(position).getPreferences().equals("Kartilya ng Katipunan")){
            holder.Icons.setImageResource(R.drawable.kartilya);
        }else if(landmarks.get(position).getPreferences().equals("Malacañang Palace")){
            holder.Icons.setImageResource(R.drawable.malacanang);
        }else if(landmarks.get(position).getPreferences().equals("Casa Manila")){
            holder.Icons.setImageResource(R.drawable.casemanila);
        }else if(landmarks.get(position).getPreferences().equals("Museo Pambata")){
            holder.Icons.setImageResource(R.drawable.muesuempambata);
        }else if(landmarks.get(position).getPreferences().equals("Money Museum")){
            holder.Icons.setImageResource(R.drawable.moneymuseum);
        }

    }

    @Override
    public int getItemCount() {
        return landmarks.size();
    }
}
