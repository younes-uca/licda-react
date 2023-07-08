package  ma.sir.vaccination.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.vaccination.bean.core.Ville;
import ma.sir.vaccination.bean.history.VilleHistory;
import ma.sir.vaccination.dao.criteria.core.VilleCriteria;
import ma.sir.vaccination.dao.criteria.history.VilleHistoryCriteria;
import ma.sir.vaccination.service.facade.admin.VilleAdminService;
import ma.sir.vaccination.ws.converter.VilleConverter;
import ma.sir.vaccination.ws.dto.VilleDto;
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

@Api("Manages ville services")
@RestController
@RequestMapping("/api/admin/ville/")
public class VilleRestAdmin  extends AbstractController<Ville, VilleDto, VilleHistory, VilleCriteria, VilleHistoryCriteria, VilleAdminService, VilleConverter> {



    @ApiOperation("upload one ville")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple villes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all villes")
    @GetMapping("")
    public ResponseEntity<List<VilleDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all villes")
    @GetMapping("optimized")
    public ResponseEntity<List<VilleDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a ville by id")
    @GetMapping("id/{id}")
    public ResponseEntity<VilleDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  ville")
    @PostMapping("")
    public ResponseEntity<VilleDto> save(@RequestBody VilleDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  ville")
    @PutMapping("")
    public ResponseEntity<VilleDto> update(@RequestBody VilleDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of ville")
    @PostMapping("multiple")
    public ResponseEntity<List<VilleDto>> delete(@RequestBody List<VilleDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified ville")
    @DeleteMapping("")
    public ResponseEntity<VilleDto> delete(@RequestBody VilleDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified ville")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple villes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds villes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<VilleDto>> findByCriteria(@RequestBody VilleCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated villes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody VilleCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports villes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody VilleCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets ville data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody VilleCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets ville history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets ville paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody VilleHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports ville history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody VilleHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets ville history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody VilleHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public VilleRestAdmin (VilleAdminService service, VilleConverter converter) {
        super(service, converter);
    }


}