package com.InternSearch.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.InternSearch.entity.Candidate;
import com.InternSearch.entity.Employer;
import com.InternSearch.entity.JPUser;
import com.InternSearch.repository.CandidateRepository;
import com.InternSearch.repository.EmployerRepository;
import com.InternSearch.repository.JPUserRepository;
import com.InternSearch.request.UserRegistrationRequest;
import com.InternSearch.util.Role;
import com.InternSearch.util.URLMapper;
import com.InternSearch.util.ValidateScripting;
import com.InternSearch.util.ViewMapper;

@Controller
@RequestMapping(URLMapper.REGISTRATION)
public class RegistrationController {

	public static final String REGISTRATION_MODEL = "registration";

	String univ;
	
	@Autowired
	JPUserRepository jpUserRepository;

	@Autowired
	EmployerRepository employerRepository;

	@Autowired
	CandidateRepository candidateRepository;


	@RequestMapping(method = RequestMethod.GET)
	public String loadRegistrationPage(Model model) {
		model.addAttribute(REGISTRATION_MODEL, new UserRegistrationRequest());
		model.addAttribute("registration_url", URLMapper.REGISTRATION);
		return ViewMapper.REGISTRATION;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String userRegistration(
			@Valid @ModelAttribute(REGISTRATION_MODEL) UserRegistrationRequest userRegistrationRequest,
			BindingResult result) {
		
		String name = userRegistrationRequest.getName();
		String email = userRegistrationRequest.getEmail();
		String education = userRegistrationRequest.geteducation();
		String username = userRegistrationRequest.getUsername();
		
		name = ValidateScripting.validate(name);
		email = ValidateScripting.validate(email);
		education = ValidateScripting.validate(education);
		username = ValidateScripting.validate(username);

		if (result.hasErrors()) {
			return ViewMapper.REGISTRATION;
		}

		if(Role.employer.name().equalsIgnoreCase(userRegistrationRequest.getRole())){

			System.out.println(username);
			
			employerRepository.save(new Employer(name, email, education,username));
		}

		if(Role.candidate.name().equalsIgnoreCase(userRegistrationRequest.getRole())){

			univ = userRegistrationRequest.getcollege();
			
			name = ValidateScripting.validate(name);
			email = ValidateScripting.validate(email);
			education = ValidateScripting.validate(education);
			username = ValidateScripting.validate(username);
			univ = ValidateScripting.validate(univ);
			
			candidateRepository.save(
					new Candidate(name,
							univ,
							email,
							education,
							userRegistrationRequest.getGpa(), username));
		}

		jpUserRepository.save(
				new JPUser(username,
						userRegistrationRequest.getPassword(),
						userRegistrationRequest.getRole().toLowerCase(),
						true
						));


		return ViewMapper.LOGIN;
	}
}