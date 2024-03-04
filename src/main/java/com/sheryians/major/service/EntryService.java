package com.sheryians.major.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheryians.major.model.Entry;
import com.sheryians.major.repository.EntryRepo;

@Service
public class EntryService {

	@Autowired
	EntryRepo entryRepo;
public List<Entry> getAllEntry(){
		List<Entry> list=entryRepo.findAll();
		return list;
	}

//public Entry getEntry(int id) {
//	
//	Entry e=entryRepo.getEntryById(id);
//	
//	return e;
//}
	public void addEntry(Entry entry) {
		entryRepo.save(entry);
	}
//	public void removeEntry(int id);
//	public void updateEntry(Entry entry,int id);
//	public Optional<Entry> getEntry(int id);
}
