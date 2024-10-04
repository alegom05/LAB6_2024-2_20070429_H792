package com.example.clase6gtics.controller;

import com.example.clase6gtics.entity.Director;
import com.example.clase6gtics.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/director")
public class DirectorController {


    @Autowired
    DirectorRepository directorRepository;

    @GetMapping(value = {"", "/"})
    public String listaDirectores(Model model) {
        model.addAttribute("listaDirectores", directorRepository.findAll());
        return "director/list";
    }

    @GetMapping("/new")
    public String nuevoDirector(Model model, @ModelAttribute("director") Director director) {
        model.addAttribute("listaDirectores", directorRepository.findAll());
        return "director/editFrm";
    }
    /*

    @PostMapping("/save")
    public String guardarProducto(RedirectAttributes attr, Model model,
                                  @ModelAttribute("director") @Valid Director director, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) { //si no hay errores, se realiza el flujo normal

            if (director.getNombre().equals("gaseosa")) {
                model.addAttribute("msg", "Error al crear director");
                model.addAttribute("listaDirectores", directorRepository.findAll());
                return "pelicula/editFrm";
            } else {
                if (director.getId() == 0) {
                    attr.addFlashAttribute("msg", "Película creada exitosamente");
                } else {
                    attr.addFlashAttribute("msg", "Película actualizada exitosamente");
                }
                directorRepository.save(director);
                return "redirect:/pelicula";
            }

        } else { //hay al menos 1 error
            model.addAttribute("listaDirectores", directorRepository.findAll());
            return "product/editFrm";
        }
    }
    @GetMapping("/edit")
    public String editarTransportista(@ModelAttribute("pelicula") Pelicula pelicula,
                                      Model model, @RequestParam("id") int id) {

        Optional<Pelicula> optProduct = directorRepository.findById(id);

        if (optProduct.isPresent()) {
            pelicula = optProduct.get();
            model.addAttribute("pelicula", pelicula);
            model.addAttribute("listaDirectores", directorRepository.findAll());
            return "pelicula/editFrm";
        } else {
            return "redirect:/pelicula";
        }


    }


    @GetMapping("/delete")
    public String borrarTransportista(@RequestParam("id") int id,
                                      RedirectAttributes attr) {

        Optional<Director> optProduct = directorRepository.findById(id);

        if (optProduct.isPresent()) {
            directorRepository.deleteById(id);
            attr.addFlashAttribute("msg", "Película borrada exitosamente");
        }
        return "redirect:/pelicula";

    }

     */

   /* @InitBinder("product")
    public void validador(WebDataBinder binder) {

        binder.registerCustomEditor(BigDecimal.class, "unitprice", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                try{
                    BigDecimal bigDecimal = new BigDecimal(text);
                    this.setValue(bigDecimal);
                }catch (NumberFormatException e){
                    this.setValue(0);
                }
            }
        });
    }*/


}
