package com.allam.revampgopets.ui.allChats.mainScreens;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.allam.revampgopets.R;
import com.allam.revampgopets.databinding.ActivitySelectContactBinding;
import com.allam.revampgopets.ui.allChats.models.ChatModel;

import java.util.Objects;

public class SelectContactActivity extends AppCompatActivity {
    private ActivitySelectContactBinding binding;
    private SelectContactViewModel selectContactViewModel;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_select_contact);
        selectContactViewModel = new ViewModelProvider(this).get(SelectContactViewModel.class);
        setSupportActionBar(binding.mainAppToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        binding.insertChatOwner.setOnClickListener(view -> insert());
        binding.update.setOnClickListener(view -> select());
        binding.viewALlChatsOwners.setOnClickListener(view -> getAllChatsOwners());
        binding.tv.setMovementMethod(new ScrollingMovementMethod());
    }

    private void insert() {
        ChatModel chatModel = new ChatModel("chatImage", "chatName", "lastMassage", "12-12-2012", 1);
        selectContactViewModel.insertChatOwner(chatModel);
        binding.tv.setText("");
    }

    private void select() {
        selectContactViewModel.selectChatOwner(1);
        selectContactViewModel.selectedChatOwner.observe(this, chatModel -> {
            chatModel.setChatName(binding.editText.getText().toString());
            selectContactViewModel.insertChatOwner(chatModel);
            getAllChatsOwners();
        });

    }

    private void update(ChatModel chatModel) {
        chatModel.setStatus(2);
        selectContactViewModel.updateChatOwner(chatModel);
    }


    private void getAllChatsOwners() {
        binding.tv.setText("");
        selectContactViewModel.allChatsOwnersList.observe(this, chatModels -> {
            for (int i = 0; i < chatModels.size(); i++) {
                ChatModel item = chatModels.get(i);
                String s = " ID:" + item.getId() + "\n NAME:" + item.getChatName() + "\n IMAGE:" + item.getChatImage() + "\n LAST_MASSAGE:" + item.getLastMessage() + "\n TIME:" + item.getTime() + "\n STATUS:" + item.getStatus() + "\n\n";
                binding.tv.append(s);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.select_contact_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}