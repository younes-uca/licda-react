package  ma.sir.vaccination.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.vaccination.bean.core.EffetIndesirable;
import ma.sir.vaccination.bean.history.EffetIndesirableHistory;
import ma.sir.vaccination.dao.criteria.core.EffetIndesirableCriteria;
import ma.sir.vaccination.dao.criteria.history.EffetIndesirableHistoryCriteria;
import ma.sir.vaccination.service.facade.admin.EffetIndesirableAdminService;
import ma.sir.vaccination.ws.converter.EffetIndesirableConverter;
import ma.sir.vaccination.ws.dto.EffetIndesirableDto;
import ma.sir.vaccination.zynerator.controller.AbstractController;
import ma.sir.vaccination.zynerator.dto.AuditEntityDto;
import ma.sir.vaccination.zynerator.util.PaginatedList;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.sir.vaccination.zynerator.process.Result;

import org.springframework.http.HttpEntity;

import org.springframework.web.multipart.MultipartFile;
import ma.sir.vaccination.zynerator.dto.FileTempDto;

@Api("Manages effetIndesirable services")
@RestController
@RequestMapping("/api/admin/effetIndesirable/")
public class EffetIndesirableRestAdmin  extends AbstractController<EffetIndesirable, EffetIndesirableDto, EffetIndesirableHistory, EffetIndesirableCriteria, EffetIndesirableHistoryCriteria, EffetIndesirableAdminService, EffetIndesirableConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody EffetIndesirableDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one effetIndesirable")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple effetIndesirables")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all effetIndesirables")
    @GetMapping("")
    public ResponseEntity<List<EffetIndesirableDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a effetIndesirable by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EffetIndesirableDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  effetIndesirable")
    @PostMapping("")
    public ResponseEntity<EffetIndesirableDto> save(@RequestBody EffetIndesirableDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  effetIndesirable")
    @PutMapping("")
    public ResponseEntity<EffetIndesirableDto> update(@RequestBody EffetIndesirableDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of effetIndesirable")
    @PostMapping("multiple")
    public ResponseEntity<List<EffetIndesirableDto>> delete(@RequestBody List<EffetIndesirableDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified effetIndesirable")
    @DeleteMapping("")
    public ResponseEntity<EffetIndesirableDto> delete(@RequestBody EffetIndesirableDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified effetIndesirable")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple effetIndesirables by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by rendezVous id")
    @GetMapping("rendezVous/id/{id}")
    public List<EffetIndesirable> findByRendezVousId(@PathVariable Long id){
        return service.findByRendezVousId(id);
    }
    @ApiOperation("delete by rendezVous id")
    @DeleteMapping("rendezVous/id/{id}")
    public int deleteByRendezVousId(@PathVariable Long id){
        return service.deleteByRendezVousId(id);
    }
    @ApiOperation("Finds effetIndesirables by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EffetIndesirableDto>> findByCriteria(@RequestBody EffetIndesirableCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated effetIndesirables by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EffetIndesirableCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports effetIndesirables by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EffetIndesirableCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets effetIndesirable data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EffetIndesirableCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets effetIndesirable history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets effetIndesirable paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody EffetIndesirableHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports effetIndesirable history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody EffetIndesirableHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets effetIndesirable history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody EffetIndesirableHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public EffetIndesirableRestAdmin (EffetIndesirableAdminService service, EffetIndesirableConverter converter) {
        super(service, converter);
    }


}