package com.eazybytes.eazyschool.service;

import com.eazybytes.eazyschool.constants.EazySchoolConstants;
import com.eazybytes.eazyschool.model.Contact;
import com.eazybytes.eazyschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/*
@Slf4j, is a Lombok-provided annotation that will automatically generate an SLF4J
Logger static property in the class at compilation time.
* */
@Slf4j
@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    /**
     * Save Contact Details into DB
     * @param contact
     * @return boolean
     */
    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = false;
        contact.setStatus(EazySchoolConstants.OPEN);
        Contact savedContact = contactRepository.save(contact);
        if(null != savedContact && savedContact.getContactId()>0) {
            isSaved = true;
        }
        return isSaved;
    }

//    public List<Contact> findMsgsWithOpenStatus(){
//        List<Contact> contactMsgs = contactRepository.findByStatus(EazySchoolConstants.OPEN);
//        return contactMsgs;
//    }

    public boolean updateMsgStatus(int contactId){
        boolean isUpdated = false;
        Optional<Contact> contact = contactRepository.findById(contactId);
        contact.ifPresent(contact1 -> {
            contact1.setStatus(EazySchoolConstants.CLOSE);
        });
        Contact updatedContact = contactRepository.save(contact.get());
        if(null != updatedContact && updatedContact.getUpdatedBy()!=null) {
            isUpdated = true;
        }
        return isUpdated;
    }
    
	public Page<Contact> findMsgsForTest(int pageNum, String sortField, String sortDir) {
		int pageSize = 5;
		String findByIdAndMobile = contactRepository.findByIdAndMobile(1, "2176436587");
		
		Pageable pageable1 = PageRequest.of(pageNum - 1, pageSize,Sort.by(sortField).ascending());
		
//		Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
//				sortDir.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending());

		Page<Contact> msgPage = contactRepository.findByStatus(EazySchoolConstants.OPEN, pageable1);
		return msgPage;
	}

}
