package com.ricardo.victor.d2d;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ricardo.victor.data.GuardService;
import com.ricardo.victor.data.pojo.VisitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link VisitFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class VisitFragment extends Fragment {
    ListView lvVisit;
    private ProgressDialog pd;
    private OnFragmentInteractionListener mListener;

    public VisitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view= inflater.inflate(R.layout.fragment_visit, container, false);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://172.16.11.250:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GuardService service=retrofit.create(GuardService.class);
        Call<VisitService> call=service.Visits();
        call.enqueue(new Callback<VisitService>() {
            @Override
            public void onResponse(Call<VisitService> call, Response<VisitService> response) {
                ArrayList list=(ArrayList) response.body().getVisit();

                lvVisit=(ListView)view.findViewById(R.id.listViewVisitFrag);
                ListAdapter adapter=new ListAdapter(getActivity(),list);
                lvVisit.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<VisitService> call, Throwable t) {

            }
        });


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
