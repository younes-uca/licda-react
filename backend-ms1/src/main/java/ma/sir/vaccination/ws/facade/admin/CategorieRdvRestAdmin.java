package  ma.sir.vaccination.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.vaccination.bean.core.CategorieRdv;
import ma.sir.vaccination.bean.history.CategorieRdvHistory;
import ma.sir.vaccination.dao.criteria.core.CategorieRdvCriteria;
import ma.sir.vaccination.dao.criteria.history.CategorieRdvHistoryCriteria;
import ma.sir.vaccination.service.facade.admin.CategorieRdvAdminService;
import ma.sir.vaccination.ws.converter.CategorieRdvConverter;
import ma.sir.vaccination.ws.dto.CategorieRdvDto;
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

@Api("Manages categorieRdv services")
@RestController
@RequestMapping("/api/admin/categorieRdv/")
public class CategorieRdvRestAdmin  extends AbstractController<CategorieRdv, CategorieRdvDto, CategorieRdvHistory, CategorieRdvCriteria, CategorieRdvHistoryCriteria, CategorieRdvAdminService, CategorieRdvConverter> {



    @ApiOperation("upload one categorieRdv")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple categorieRdvs")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all categorieRdvs")
    @GetMapping("")
    public ResponseEntity<List<CategorieRdvDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all categorieRdvs")
    @GetMapping("optimized")
    public ResponseEntity<List<CategorieRdvDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a categorieRdv by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CategorieRdvDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  categorieRdv")
    @PostMapping("")
    public ResponseEntity<CategorieRdvDto> save(@RequestBody CategorieRdvDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  categorieRdv")
    @PutMapping("")
    public ResponseEntity<CategorieRdvDto> update(@RequestBody CategorieRdvDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of categorieRdv")
    @PostMapping("multiple")
    public ResponseEntity<List<CategorieRdvDto>> delete(@RequestBody List<CategorieRdvDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified categorieRdv")
    @DeleteMapping("")
    public ResponseEntity<CategorieRdvDto> delete(@RequestBody CategorieRdvDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified categorieRdv")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple categorieRdvs by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds categorieRdvs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CategorieRdvDto>> findByCriteria(@RequestBody CategorieRdvCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated categorieRdvs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CategorieRdvCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports categorieRdvs by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CategorieRdvCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets categorieRdv data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CategorieRdvCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets categorieRdv history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets categorieRdv paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody CategorieRdvHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports categorieRdv history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody CategorieRdvHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets categorieRdv history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody CategorieRdvHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public CategorieRdvRestAdmin (CategorieRdvAdminService service, CategorieRdvConverter converter) {
        super(service, converter);
    }


}