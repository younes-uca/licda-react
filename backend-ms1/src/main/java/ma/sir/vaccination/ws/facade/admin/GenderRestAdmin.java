package  ma.sir.vaccination.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.vaccination.bean.core.Gender;
import ma.sir.vaccination.bean.history.GenderHistory;
import ma.sir.vaccination.dao.criteria.core.GenderCriteria;
import ma.sir.vaccination.dao.criteria.history.GenderHistoryCriteria;
import ma.sir.vaccination.service.facade.admin.GenderAdminService;
import ma.sir.vaccination.ws.converter.GenderConverter;
import ma.sir.vaccination.ws.dto.GenderDto;
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

@Api("Manages gender services")
@RestController
@RequestMapping("/api/admin/gender/")
public class GenderRestAdmin  extends AbstractController<Gender, GenderDto, GenderHistory, GenderCriteria, GenderHistoryCriteria, GenderAdminService, GenderConverter> {



    @ApiOperation("upload one gender")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple genders")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all genders")
    @GetMapping("")
    public ResponseEntity<List<GenderDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all genders")
    @GetMapping("optimized")
    public ResponseEntity<List<GenderDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a gender by id")
    @GetMapping("id/{id}")
    public ResponseEntity<GenderDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  gender")
    @PostMapping("")
    public ResponseEntity<GenderDto> save(@RequestBody GenderDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  gender")
    @PutMapping("")
    public ResponseEntity<GenderDto> update(@RequestBody GenderDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of gender")
    @PostMapping("multiple")
    public ResponseEntity<List<GenderDto>> delete(@RequestBody List<GenderDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified gender")
    @DeleteMapping("")
    public ResponseEntity<GenderDto> delete(@RequestBody GenderDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified gender")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple genders by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds genders by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<GenderDto>> findByCriteria(@RequestBody GenderCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated genders by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody GenderCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports genders by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody GenderCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets gender data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody GenderCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets gender history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets gender paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody GenderHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports gender history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody GenderHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets gender history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody GenderHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public GenderRestAdmin (GenderAdminService service, GenderConverter converter) {
        super(service, converter);
    }


}