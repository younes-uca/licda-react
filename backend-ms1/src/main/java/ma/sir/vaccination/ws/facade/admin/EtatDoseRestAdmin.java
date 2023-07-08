package  ma.sir.vaccination.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.vaccination.bean.core.EtatDose;
import ma.sir.vaccination.bean.history.EtatDoseHistory;
import ma.sir.vaccination.dao.criteria.core.EtatDoseCriteria;
import ma.sir.vaccination.dao.criteria.history.EtatDoseHistoryCriteria;
import ma.sir.vaccination.service.facade.admin.EtatDoseAdminService;
import ma.sir.vaccination.ws.converter.EtatDoseConverter;
import ma.sir.vaccination.ws.dto.EtatDoseDto;
import ma.sir.vaccination.zynerator.controller.AbstractController;
import ma.sir.vaccination.zynerator.dto.AuditEntityDto;
import ma.sir.vaccination.zynerator.util.PaginatedList;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.sir.vaccination.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.sir.vaccination.zynerator.dto.FileTempDto;

@Api("Manages etatDose services")
@RestController
@RequestMapping("/api/admin/etatDose/")
public class EtatDoseRestAdmin  extends AbstractController<EtatDose, EtatDoseDto, EtatDoseHistory, EtatDoseCriteria, EtatDoseHistoryCriteria, EtatDoseAdminService, EtatDoseConverter> {



    @ApiOperation("upload one etatDose")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple etatDoses")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all etatDoses")
    @GetMapping("")
    public ResponseEntity<List<EtatDoseDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all etatDoses")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatDoseDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a etatDose by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatDoseDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  etatDose")
    @PostMapping("")
    public ResponseEntity<EtatDoseDto> save(@RequestBody EtatDoseDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  etatDose")
    @PutMapping("")
    public ResponseEntity<EtatDoseDto> update(@RequestBody EtatDoseDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of etatDose")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatDoseDto>> delete(@RequestBody List<EtatDoseDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified etatDose")
    @DeleteMapping("")
    public ResponseEntity<EtatDoseDto> delete(@RequestBody EtatDoseDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified etatDose")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple etatDoses by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds etatDoses by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatDoseDto>> findByCriteria(@RequestBody EtatDoseCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated etatDoses by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatDoseCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports etatDoses by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EtatDoseCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets etatDose data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatDoseCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets etatDose history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets etatDose paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody EtatDoseHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports etatDose history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody EtatDoseHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets etatDose history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody EtatDoseHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public EtatDoseRestAdmin (EtatDoseAdminService service, EtatDoseConverter converter) {
        super(service, converter);
    }


}