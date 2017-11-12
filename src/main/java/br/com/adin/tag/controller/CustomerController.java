package br.com.adin.tag.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.adin.tag.model.Customer;
import br.com.adin.tag.model.ModalContent;
import br.com.adin.tag.model.TrackedHtmlControl;
import br.com.adin.tag.model.TrackerConfiguration;
import br.com.adin.tag.model.UrlsToTrack;
import br.com.adin.tag.model.UserTrackingConfiguration;
import br.com.adin.tag.model.UserTrackingConfigurationTriggerButton;
import br.com.adin.tag.repository.CustomersRepository;
import br.com.adin.tag.repository.ModalContentRepository;
import br.com.adin.tag.repository.TrackedHtmlControlRepository;
import br.com.adin.tag.repository.TrackerConfigurationRepository;
import br.com.adin.tag.repository.UrlsToTrackRepository;
import br.com.adin.tag.repository.UserTrackingConfigurationRepository;
import br.com.adin.tag.repository.UserTrackingConfigurationTriggerButtonRepository;

@Controller
@RequestMapping("cadastro/customer")
public class CustomerController {

	@Autowired
	private CustomersRepository customers;

	@Autowired
	private TrackerConfigurationRepository trackers;

	@Autowired
	private UrlsToTrackRepository urls;

	@Autowired
	private TrackedHtmlControlRepository trackeds;

	@Autowired
	private ModalContentRepository modals;

	@Autowired
	private UserTrackingConfigurationRepository users;

	@Autowired
	private UserTrackingConfigurationTriggerButtonRepository userTrackings;

	private Customer customer;

	private TrackerConfiguration tracker;

	private UserTrackingConfiguration userTracking;

	@GetMapping
	private ModelAndView listar() {
		ModelAndView mv = new ModelAndView("/cadastro/GerarTAG");
		this.tracker = new TrackerConfiguration();
		mv.addObject(new Customer());
		mv.addObject(new UrlsToTrack());
		mv.addObject(new TrackedHtmlControl());
		mv.addObject(new UserTrackingConfiguration());
		mv.addObject(new UserTrackingConfigurationTriggerButton());

		mv.addObject(new ModalContent());
		return mv;
	}
	
	@GetMapping("abrirPesquisa")
	private ModelAndView abrirPesquisa(){
		System.out.println(">>>>>>>>>>>>> Entrei aqui");
		ModelAndView mv = new ModelAndView("/cadastro/PesquisaTAG");
		mv.addObject(new Customer());
		return mv;
	}
	
	@PostMapping("pesquisaTAG")
	private ModelAndView pesquisaProduto(@ModelAttribute("customer") Customer customer){
		ModelAndView mv = new ModelAndView("/cadastro/PesquisaTAG");
		mv.addObject("customers", customers.pesquisaPorNome("%" + customer.getCustomerName().toUpperCase() + "%"));
		return mv;
	}
	

	@GetMapping("editar/{id}")
	public ModelAndView edit(@PathVariable("id") String id) {
		ModelAndView mv = new ModelAndView("cadastro/GerarTAG");
		
		this.customer = customers.findOne(id);
		this.tracker = trackers.buscarTracker(id);
		this.userTracking = users.Pesquisar(this.tracker.getId());
		
		mv.addObject(new UrlsToTrack());
		mv.addObject(new TrackedHtmlControl());
		mv.addObject(new ModalContent());
		mv.addObject(new UserTrackingConfiguration());
		mv.addObject(new UserTrackingConfigurationTriggerButton());

		mv.addObject("urls", urls.listarUrls(this.tracker.getId()));
		mv.addObject("trackedHtmlControls",
				trackeds.listar(this.tracker.getId()));
		mv.addObject("modals", modals.listar(this.tracker.getId()));
		mv.addObject("users", users.listar(this.tracker.getId()));
		if (this.userTracking != null) {
			mv.addObject("userTrackings",
					userTrackings.listar(this.userTracking.getId()));
		} else {
			mv.addObject("userTrackings", null);
		}

		return mv.addObject(customers.findOne(id));
	}

	@GetMapping("editar/url/excluir/{id}")
	public String deleteUrl(@PathVariable("id") String id) {
		urls.deletarUrl(id);
		return "redirect:/cadastro/customer/editar/" + this.customer.getId();
	}

	@GetMapping("editar/trackedhtmlcontrol/excluir/{id}")
	public String deleteTrackedControl(@PathVariable("id") String id) {
		trackeds.delete(id);
		return "redirect:/cadastro/customer/editar/" + this.customer.getId();
	}

	@GetMapping("editar/modalcontent/excluir/{id}")
	public String deleteModalContent(@PathVariable("id") String id) {
		modals.delete(id);
		return "redirect:/cadastro/customer/editar/" + this.customer.getId();
	}

	@GetMapping("editar/usertrackingconfiguration/excluir/{id}")
	public String deleteUserTrackingConfiguration(@PathVariable("id") String id) {
		userTrackings.deletar(this.userTracking.getId());
		users.delete(id);
		return "redirect:/cadastro/customer/editar/" + this.customer.getId();
	}

	@GetMapping("editar/usertrackingconfigurationtriggerbutton/excluir/{id}")
	public String deleteUserTrackingConfigurationTriggerButton(@PathVariable("id") String id) {
		userTrackings.deletar(id);
		return "redirect:/cadastro/customer/editar/" + this.customer.getId();
	}

	
	
	
	@PostMapping
	public String salvar(Customer customer) {
		this.customer = customers.save(customer);
		this.tracker.setCustomer(this.customer);
		this.tracker = trackers.save(tracker);
		return "redirect:/cadastro/customer/editar/" + this.customer.getId();
	}

	@PostMapping("url")
	public String addURL(UrlsToTrack url) {
		url.setTrackerConfiguration(this.tracker);
		urls.save(url);
		return "redirect:/cadastro/customer/editar/" + customer.getId();
	}

	@PostMapping("trackedhtmlcontrol")
	public String addtrackedhtmlcontrol(TrackedHtmlControl t) {
		t.setTrackerConfiguration(this.tracker);
		trackeds.save(t);
		return "redirect:/cadastro/customer/editar/" + customer.getId();
	}

	@PostMapping("modalcontent")
	public String addModal(ModalContent m) {
		m.setTrackerConfiguration(this.tracker);
		modals.save(m);
		return "redirect:/cadastro/customer/editar/" + customer.getId();
	}

	@PostMapping("userTrackingConfiguration")
	public String addUser(UserTrackingConfiguration u) {
		u.setTrackerConfiguration(this.tracker);
		this.userTracking = users.save(u);
		return "redirect:/cadastro/customer/editar/" + customer.getId();
	}

	@PostMapping("userTrackingConfigurationTriggerButton")
	public String addUserTracking(UserTrackingConfigurationTriggerButton u) {
		u.setUserTrackingConfiguration(this.userTracking);
		userTrackings.save(u);
		return "redirect:/cadastro/customer/editar/" + customer.getId();
	}
}
