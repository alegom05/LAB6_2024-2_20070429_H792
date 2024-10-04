package com.example.clase6gtics.controller;

import com.example.clase6gtics.entity.Pelicula;
import com.example.clase6gtics.repository.PeliculaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/pelicula")
public class PeliculaController {


    @Autowired
    PeliculaRepository peliculaRepository;

    @GetMapping(value = {"", "/"})
    public String listaProductos(Model model) {
        model.addAttribute("listaPeliculas", peliculaRepository.findAll());
        return "pelicula/list";
    }
    /*
    @GetMapping("/new")
    public String nuevoProductoFrm(Model model, @ModelAttribute("pelicula") Product product) {
        model.addAttribute("listaEmpleados", peliculaRepository.findAll());
        return "pelicula/editFrm";
    }

    @PostMapping("/save")
    public String guardarProducto(RedirectAttributes attr, Model model,
                                  @ModelAttribute("pelicula") @Valid Pelicula pelicula, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) { //si no hay errores, se realiza el flujo normal

            if (pelicula.getTitulo().equals("gaseosa")) {
                model.addAttribute("msg", "Error al crear producto");
                model.addAttribute("listaEmpleados", peliculaRepository.findAll());
                return "pelicula/editFrm";
            } else {
                if (pelicula.getId() == 0) {
                    attr.addFlashAttribute("msg", "Película creada exitosamente");
                } else {
                    attr.addFlashAttribute("msg", "Película actualizada exitosamente");
                }
                peliculaRepository.save(pelicula);
                return "redirect:/pelicula";
            }

        } else { //hay al menos 1 error
            model.addAttribute("listaEmpleados", peliculaRepository.findAll());
            return "product/editFrm";
        }
    }

    @GetMapping("/edit")
    public String editarTransportista(@ModelAttribute("pelicula") Pelicula pelicula,
                                      Model model, @RequestParam("id") int id) {

        Optional<Pelicula> optProduct = peliculaRepository.findById(id);

        if (optProduct.isPresent()) {
            pelicula = optProduct.get();
            model.addAttribute("pelicula", pelicula);
            model.addAttribute("listaEmpleados", peliculaRepository.findAll());
            return "pelicula/editFrm";
        } else {
            return "redirect:/pelicula";
        }
    }

    @GetMapping("/delete")
    public String borrarTransportista(@RequestParam("id") int id,
                                      RedirectAttributes attr) {

        Optional<Pelicula> optProduct = peliculaRepository.findById(id);

        if (optProduct.isPresent()) {
            peliculaRepository.deleteById(id);
            attr.addFlashAttribute("msg", "Película borrada exitosamente");
        }
        return "redirect:/pelicula";

    }

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
