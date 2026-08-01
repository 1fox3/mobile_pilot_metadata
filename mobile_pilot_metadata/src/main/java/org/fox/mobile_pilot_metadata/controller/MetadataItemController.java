package org.fox.mobile_pilot_metadata.controller;

import org.fox.mobile_pilot_metadata.model.MetadataItem;
import org.fox.mobile_pilot_metadata.repository.MetadataItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/metadata")
public class MetadataItemController {

    private final MetadataItemRepository metadataItemRepository;

    public MetadataItemController(MetadataItemRepository metadataItemRepository) {
        this.metadataItemRepository = metadataItemRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MetadataItem create(@RequestBody MetadataItem metadataItem) {
        Instant now = Instant.now();
        metadataItem.setId(null);
        metadataItem.setCreatedAt(now);
        metadataItem.setUpdatedAt(now);
        return metadataItemRepository.save(metadataItem);
    }

    @GetMapping
    public List<MetadataItem> list() {
        return metadataItemRepository.findAll();
    }

    @GetMapping("/{id}")
    public MetadataItem getById(@PathVariable String id) {
        return metadataItemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Metadata item not found"));
    }

    @PutMapping("/{id}")
    public MetadataItem update(@PathVariable String id, @RequestBody MetadataItem request) {
        MetadataItem existing = metadataItemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Metadata item not found"));

        existing.setTitle(request.getTitle());
        existing.setContent(request.getContent());
        existing.setUpdatedAt(Instant.now());

        return metadataItemRepository.save(existing);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        if (!metadataItemRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Metadata item not found");
        }
        metadataItemRepository.deleteById(id);
    }
}
