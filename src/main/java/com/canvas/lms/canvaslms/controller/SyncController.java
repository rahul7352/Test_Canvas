package com.canvas.lms.canvaslms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.canvas.lms.canvaslms.exception.CanvasApiException;
import com.canvas.lms.canvaslms.service.ICanvasSyncService;

@Controller
public class SyncController {
	
	@Autowired
	private ICanvasSyncService canvasSyncService;
	
	@GetMapping("/sync")
    public String syncPage() {
        return "sync";
    }
	
	@PostMapping("/sync")
    public String startSync(Model model) throws CanvasApiException {
		canvasSyncService.syncCanvas();
        model.addAttribute("syncMessage", "Synchronization process initiated successfully.");
        return "sync";
    }

}
