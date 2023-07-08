import {Button} from 'primereact/button';
import {Column} from 'primereact/column';
import {Dropdown} from 'primereact/dropdown';
import {TabView, TabPanel} from 'primereact/tabview';
import {DataTable} from 'primereact/datatable';
import {Dialog} from 'primereact/dialog';
import {InputNumber, InputNumberChangeEvent} from 'primereact/inputnumber';
import {InputText} from 'primereact/inputtext';
import {classNames} from 'primereact/utils';
import { InputTextarea } from 'primereact/inputtextarea';
import {AxiosResponse} from 'axios';
import React, {useEffect, useState} from 'react';
import {Calendar, CalendarChangeEvent} from 'primereact/calendar';
import { format } from 'date-fns';
import {InputNumberChangeEvent} from 'primereact/inputnumber';
import { InputSwitch } from "primereact/inputswitch";
import {MultiSelect} from "primereact/multiselect";import {MessageService} from "/pages/controller/service/MessageService";

import {DoseService} from '/pages/controller/service/Dose.service';
import  {DoseDto}  from '/pages/controller/model/Dose.model';

import {EtatDoseDto} from '/pages/controller/model/EtatDose.model';
import {EtatDoseService} from '/pages/controller/service/EtatDose.service';
import {RendezVousDto} from '/pages/controller/model/RendezVous.model';
import {RendezVousService} from '/pages/controller/service/RendezVous.service';
const Edit = ({visible, onClose, showToast, selectedItem, update}) => {

    const emptyItem = new DoseDto();
    const [submitted, setSubmitted] = useState(false);
    const [activeIndex, setActiveIndex] = useState<number>(0);
    const [activeTab, setActiveTab] = useState(0);
    const [item, setItem] = useState<DoseDto>( emptyItem);
    const [etatDoses, setEtatDoses] = useState<EtatDoseDto[]>([]);
    type EtatDoseResponse = AxiosResponse<EtatDoseDto[]>;
    const [rendezVouss, setRendezVouss] = useState<RendezVousDto[]>([]);
    type RendezVousResponse = AxiosResponse<RendezVousDto[]>;

    useEffect(() => {
        const fetchData = async () => {
            try {
                // if pojo = Commande this line must dispolay client (in command), product(in commanandItem)
                const [rendezVoussResponse ,etatDosesResponse ] = await Promise.all<RendezVousResponse,EtatDoseResponse>([
                    RendezVousService.getList(),
                    EtatDoseService.getList(),
                ]);
                setRendezVouss(rendezVoussResponse.data);
                setEtatDoses(etatDosesResponse.data);
            } catch (error) {
                console.error(error);
            }
        };
    fetchData();
    setItem(selectedItem ? { ...selectedItem } : { ...emptyItem });
    }, [selectedItem]);



    const onDropdownChange = (e, field) => {
        setItem((prevState) => ({ ...prevState, [field]: e.value, }));
    };


    const onTabChange = (e: { index: number }) => {
        setActiveIndex(e.index);
    };

    const hideDialog = () => {
        setSubmitted(false);
        onClose();
    };

    const saveItem = async () => {
        setSubmitted(true);
        let _item = {...item};
        try {
            if (_item.id) {
                await DoseService.update(_item).then((response) => {
                    console.log(response.data);
                    update(response.data);
                    onClose();
                });
                MessageService.showToast(showToast, { severity: 'success', summary: 'Successful', detail: 'Dose Updated', life: 3000 });
            }
        } catch (error) {
            console.log(error);
            MessageService.showToast(showToast, { severity: 'Error', summary: 'Error', detail: 'Failed to save dose', life: 3000 });
        }
    };

    const onInputTextChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, name: string) => {
        const val = (e.target && e.target.value) || '';
        let _item = {...item};
        _item[`${name}`] = val;
        setItem(_item);
    };

    const onInputDateChange = (e: CalendarChangeEvent, name: string) => {
        const val = e.value || ''; // Utilisez e.value au lieu de e.target.value
        let _item = { ...item};
        _item[`${name}`] = val;
        setItem(_item);
    };

    const onInputNumerChange = (e: InputNumberChangeEvent, name: string) => {
        const val = e.value === null ? null : +e.value;
        setItem((prevItem) => ({ ...prevItem, [name]: val, }));
    };

    const onMultiSelectChange = (e, field) => {
        if (e && e.value && Array.isArray(e.value)) {
            const selectedValues = e.value.map(option => option && option.value);
            setItem(prevState => ({ ...prevState, [field]: selectedValues, }));
        }
    };

    const onBooleanInputChange = (e: any, name: string) => {
        const val = e.value;
        setItem((prevItem) => ({ ...prevItem, [name]: val, }));
    };

    const itemDialogFooter = ( <>
        <Button label="Cancel" icon="pi pi-times" text onClick={hideDialog} />
        <Button label="Save" icon="pi pi-check" text onClick={saveItem} /> < />
    );

return(
    <Dialog visible={visible} style={{width: '70vw'}} header="Dose" modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog}>
        <TabView activeIndex={activeIndex} onTabChange={onTabChange}>
            <TabPanel header="Dose">
                <div className="formgrid grid">
                    <div className="field col-6">
                        <label htmlFor="rendezVous">RendezVous</label>
                        <Dropdown  id="rendezVousDropdown"  value={item ? item.rendezVous : ''} options={rendezVouss} onChange={(e) => onDropdownChange(e, 'rendezVous')}   placeholder="Sélectionnez un rendezVous" filter filterPlaceholder="Rechercher un rendezVous" optionLabel="id" />
                    </div>
                    <div className="field col-6">
                        <label htmlFor="etatDose">EtatDose</label>
                        <Dropdown  id="etatDoseDropdown"  value={item ? item.etatDose : ''} options={etatDoses} onChange={(e) => onDropdownChange(e, 'etatDose')}   placeholder="Sélectionnez un etatDose" filter filterPlaceholder="Rechercher un etatDose" optionLabel="libelle" />
                    </div>
                    <div className="field col-6">
                        <label htmlFor="dateDebutPrevu">DateDebutPrevu</label>
                        <Calendar id="dateDebutPrevu" value={item ? item.dateDebutPrevu : ''} onChange={(e) => onInputDateChange(e, 'dateDebutPrevu')} dateFormat="dd/mm/yy" showTime />
                    </div>
                    <div className="field col-6">
                        <label htmlFor="dateDebutEffectif">DateDebutEffectif</label>
                        <Calendar id="dateDebutEffectif" value={item ? item.dateDebutEffectif : ''} onChange={(e) => onInputDateChange(e, 'dateDebutEffectif')} dateFormat="dd/mm/yy" showTime />
                    </div>
                    <div className="field col-6">
                        <label htmlFor="description">Description</label>
                        <span className="p-float-label">
                            <InputTextarea id="description" value={item ? item.description : ''} onChange={(e) => onInputTextChange(e, 'description')} rows={5} cols={30}/>
                        </span>
                    </div>
                </div>
            < /TabPanel>
        </TabView>
    </Dialog>
);
};
export default Edit;


