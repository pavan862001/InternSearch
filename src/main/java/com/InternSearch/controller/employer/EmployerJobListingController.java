package com.InternSearch.controller.employer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.InternSearch.entity.Employer;
import com.InternSearch.repository.EmployerRepository;
import com.InternSearch.repository.JobRepository;
import com.InternSearch.util.URLMapper;
import com.InternSearch.util.ViewMapper;

@Controller
@RequestMapping(URLMapper.EMPLOYER_JOB_LISTING_URL)
public class EmployerJobListingController {

	@Autowired
	JobRepository jobRepository;

	@Autowired
	EmployerRepository employerRepository;

	@RequestMapping(method = RequestMethod.GET)
	public String loadEmployerJobs(Model model, Authentication auth) {
		Employer employer = employerRepository.findByUsername(auth.getName());
//		System.out.println(auth.getName()+"iii");
		model.addAttribute("jobs", jobRepository.findByEmployerId(employer.getId()));
		return ViewMapper.EMPLOYER_JOB_LISTING;
	}
}