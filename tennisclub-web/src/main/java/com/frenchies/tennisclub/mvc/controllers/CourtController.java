import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import com.frenchies.tennisclub.dto.CourtCreateDTO;
import com.frenchies.tennisclub.facade.CourtFacade;

/**
 * SpringMVC Controller for administering courts.
 *
 * @author Dore Corentin 473308
 */
@Controller
@RequestMapping("/court")
public class CourtController {

	final static Logger log = LoggerFactory.getLogger(CourtController.class);

	@Autowired
	private CourtFacade courtFacade;

	/**
	 * Shows a list of products with the ability to add, delete or edit.
	 *
	 * @param model
	 *            data to display
	 * @return JSP page name
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("courts", courtFacade.getAllCourts());
		return "court/list";
	}

	/**
	 * Prepares an empty form.
	 *
	 * @param model
	 *            data to be displayed
	 * @return JSP page
	 */
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newCourt(Model model) {
		log.debug("new()");
		model.addAttribute("courtCreate", new CourtCreateDTO());
		return "court/new";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("courtCreate") CourtCreateDTO formBean, BindingResult bindingResult,
			Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
		log.debug("create(formBean={})", formBean);
		// in case of validation error forward back to the the form
		if (bindingResult.hasErrors()) {
			for (ObjectError ge : bindingResult.getGlobalErrors()) {
				log.trace("ObjectError: {}", ge);
			}
			for (FieldError fe : bindingResult.getFieldErrors()) {
				model.addAttribute(fe.getField() + "_error", true);
				log.trace("FieldError: {}", fe);
			}
			return "court/new";
		}
		// create product
		Long id = courtFacade.createCourt(formBean);
		// report success
		redirectAttributes.addFlashAttribute("alert_success", "Court " + id + " was created");
		return "redirect:" + uriBuilder.path("/court/list").toUriString();
	}
}
