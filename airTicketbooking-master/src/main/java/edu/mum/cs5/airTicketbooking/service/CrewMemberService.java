package edu.mum.cs5.airTicketbooking.service;


import javax.transaction.Transactional;

import edu.mum.cs5.airTicketbooking.model.CrewMember;
import edu.mum.cs5.airTicketbooking.repository.CrewMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class CrewMemberService {

	@Autowired
	private CrewMemberRepository repo;

	public List<CrewMember> getBooks() {
		return repo.findAll();
	}

	public void saveBook(CrewMember book) {
		repo.save(book);
	}

	public CrewMember getBook(long id) {
		return repo.findById(id).get();
	}

	public void deleteBook(long id) {
		repo.deleteById(id);
	}
	public void updateBook(long id) {
		CrewMember book= getBook( id);
		repo.save(book);
	}
}
